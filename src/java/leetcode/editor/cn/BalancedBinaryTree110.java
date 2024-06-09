import struct.TreeNode;

/**
 * <p>给定一个二叉树，判断它是否是 <span data-keyword="height-balanced">平衡二叉树</span> &nbsp;</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" style="width: 342px; height: 221px;" />
 * <pre>
 * <strong>输入：</strong>root = [3,9,20,null,null,15,7]
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" style="width: 452px; height: 301px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,2,3,3,null,null,4,4]
 * <strong>输出：</strong>false
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = []
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中的节点数在范围 <code>[0, 5000]</code> 内</li>
 * <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1517</li><li>👎 0</li></div>
 */
public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree110().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        solution.isBalanced(root);
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
        /*
        平衡二叉树：左右子树的高度相差不超过1
         */
        boolean result = true;

        public boolean isBalanced(TreeNode root) {
            getHeight(root);
            return result;
        }

        public int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = getHeight(node.left) + 1;
            int rightHeight = getHeight(node.right) + 1;
            //只有当平衡因子 =-1，0，1时，这个树才是平衡二叉树。 left-right = 平衡因子；
            if (Math.abs(leftHeight - rightHeight) > 1) {
                result = false;
            }

            return Math.max(leftHeight, rightHeight);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}