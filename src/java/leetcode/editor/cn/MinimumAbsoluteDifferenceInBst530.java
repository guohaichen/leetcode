import struct.TreeNode;

import java.util.LinkedList;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目范围是 [2, 10⁴]
 * 0 <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 558 👎 0
 */
public class MinimumAbsoluteDifferenceInBst530 {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst530().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //思路：二叉搜索树的特性很重要，左<根<右，明显的一个中序遍历，在遍历时，找到最小的差值.
        public int getMinimumDifference(TreeNode root) {
            //先写中序遍历模板，
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            int prev = -1;
            int min = Integer.MAX_VALUE;
            while (current != null || !stack.isEmpty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    TreeNode pop = stack.pop();
                    //这里-1表实还没有访问过节点。
                    if (prev != -1) {
                        min = Math.min(min, pop.val - prev);
                    }
                    prev = pop.val;

                    current = pop.right;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}