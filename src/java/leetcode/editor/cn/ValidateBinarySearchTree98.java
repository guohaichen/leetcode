import struct.TreeNode;

import java.util.LinkedList;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目范围在[1, 10⁴] 内
 * -2³¹ <= Node.val <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2330 👎 0
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree98().new Solution();
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
        public boolean isValidBST(TreeNode root) {
            //根据二叉搜索树的特性，左节点是小于根小于右节点的，那么根据中序遍历得出，遍历结果一定是一个升序；
            //所以先将中序遍历的模板写下，再对比前节点和后节点的大小， 左 根 右
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode current = root;
            //定义prev为long最小值，因为int测试用例有个最小int值，
            long prev = Long.MIN_VALUE;

            while (current != null || !stack.isEmpty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    TreeNode pop = stack.pop();
                    if (prev>=pop.val){
                        return false;
                    }
                    prev = pop.val;
                    current = pop.right;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}