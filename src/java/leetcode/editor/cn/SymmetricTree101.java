import struct.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2704 👎 0
 */
public class SymmetricTree101 {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree101().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            //递归
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}