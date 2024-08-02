import struct.TreeNode;

/**
 * <p>二叉树中的<strong> 路径</strong> 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 <strong>至多出现一次</strong> 。该路径<strong> 至少包含一个 </strong>节点，且不一定经过根节点。</p>
 *
 * <p><strong>路径和</strong> 是路径中各节点值的总和。</p>
 *
 * <p>给你一个二叉树的根节点 <code>root</code> ，返回其 <strong>最大路径和</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" />
 * <pre>
 * <strong>输入：</strong>root = [1,2,3]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>最优路径是 2 -&gt; 1 -&gt; 3 ，路径和为 2 + 1 + 3 = 6</pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" />
 * <pre>
 * <strong>输入：</strong>root = [-10,9,20,null,null,15,7]
 * <strong>输出：</strong>42
 * <strong>解释：</strong>最优路径是 15 -&gt; 20 -&gt; 7 ，路径和为 15 + 20 + 7 = 42
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li>树中节点数目范围是 <code>[1, 3 * 10<sup>4</sup>]</code></li>
 * <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 2253</li><li>👎 0</li></div>
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum124().new Solution();
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

        int maxValue = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxValue;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            //左子树最大和
            int leftMax = Math.max(0, dfs(node.left));
            //右子树最大和
            int rightMax = Math.max(0, dfs(node.right));
            //更新最大路径和
            maxValue = Math.max(maxValue, leftMax + rightMax + node.val);
            // 返回以当前节点为起点的最大路径和
            return node.val + Math.max(leftMax, rightMax);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}