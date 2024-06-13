import struct.TreeNode;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [1, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 749 👎 0
 */
public class FindModeInBinarySearchTree501 {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree501().new Solution();
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
        public int[] findMode(TreeNode root) {
            /*
            题目要求不适用额外空间，那么我在使用栈进行中序遍历时，就进行对比
            思路就是找到pre和cur的值，进行对比，如果不一样则count记为空，并每轮进行maxCount和count对比；
            核心就是在栈的遍历过程中，找到pre和cur
            出栈的就是cur，在进行计算后，赋值给pre
             */

            int maxCount = 0, count = 0;
            TreeNode pre = null;
            List<Integer> result = new ArrayList<>();

            //中序遍历 左- 根- 右
            LinkedList<TreeNode> stack = new LinkedList<>();

            TreeNode current = root;
            if (current == null) {
                return new int[]{};
            }
            while (current != null || !stack.isEmpty()) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;

                } else {
                    TreeNode pop = stack.pop();

                    if (pre == null || pre.val != pop.val) {
                        count = 1;
                    } else {
                        count++;
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        result.clear();
                        result.add(pop.val);
                    } else if (count == maxCount) {
                        result.add(pop.val);
                    }
                    pre = pop;
                    current = pop.right;

                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}