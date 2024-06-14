/**
 * <p>假设你正在爬楼梯。需要 <code>n</code>&nbsp;阶你才能到达楼顶。</p>
 *
 * <p>每次你可以爬 <code>1</code> 或 <code>2</code> 个台阶。你有多少种不同的方法可以爬到楼顶呢？</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 2
 * <strong>输出：</strong>2
 * <strong>解释：</strong>有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 3
 * <strong>输出：</strong>3
 * <strong>解释：</strong>有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 45</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>记忆化搜索</li><li>数学</li><li>动态规划</li></div></div><br><div><li>👍 3535</li><li>👎 0</li></div>
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs70().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* 有多少种方法可以爬到楼顶
        每次可以爬1或2个台阶，那么到楼顶n时，在n-1层 只需要向上爬一个台阶，在n-2层，只需向上爬两个台阶；
        可求得递推公式 dp[n] = dp[n-1]+dp[n-2]
         */
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}