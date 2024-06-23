/**
 * <p>给你一个整数 <code>n</code> ，求恰由 <code>n</code> 个节点组成且节点值从 <code>1</code> 到 <code>n</code> 互不相同的 <strong>二叉搜索树</strong> 有多少种？返回满足题意的二叉搜索树的种数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
 * <pre>
 * <strong>输入：</strong>n = 3
 * <strong>输出：</strong>5
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 19</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>树</li><li>二叉搜索树</li><li>数学</li><li>动态规划</li><li>二叉树</li></div></div><br><div><li>👍 2509</li><li>👎 0</li></div>
 */
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees96().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
        /*
        卡特兰数规律
        f(n)=f(0)*f(n-1)+f(1)*f(n-2)....f(n-1)*f(0);
        例如 3个数时，
        1作为root left0*right2
        2作为root left1*right1
        3作为root left2*right0
        相加既得 f3
         */
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}