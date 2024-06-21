import struct.TreeNode;

/**
 * <p>给你一棵二叉树的根节点，返回该树的 <strong>直径</strong> 。</p>
 *
 * <p>二叉树的 <strong>直径</strong> 是指树中任意两个节点之间最长路径的 <strong>长度</strong> 。这条路径可能经过也可能不经过根节点 <code>root</code> 。</p>
 *
 * <p>两节点之间路径的 <strong>长度</strong> 由它们之间边数表示。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3,4,5]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>root = [1,2]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1552</li><li>👎 0</li></div>
 */
public class DiameterOfBinaryTree543 {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree543().new Solution();
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
        /*public int diameterOfBinaryTree(TreeNode root) {
         *//*
                错误思路：dfs分别求 左子树、右子树的最大深度，相加即可 和104题二叉树的最大深度差不多，结果在提交代码时错了，发现是局限了。
                我这样的做法是一定会经过根节点，而直径是指树中任意两个节点之间最长路径的长度。不一定会经过根节点；
             *//*
            int left = dfs(root.left);
            int right = dfs(root.right);
            return left + right;
        }


        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = dfs(root.left);
            int rightHeight = dfs(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }*/

        //记录全局最大直径
        int result = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return result;
        }
        //返回左右子树的最大值，并且更新直径最大值
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = dfs(root.left);
            int rightHeight = dfs(root.right);
            result = Math.max(result, leftHeight+rightHeight);
            return Math.max(leftHeight, rightHeight)+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}