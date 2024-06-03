/**
 * <p>给定一个整数数组
 * <meta charset="UTF-8" /><code>prices</code>，其中第&nbsp;<em>&nbsp;</em><code>prices[i]</code>&nbsp;表示第&nbsp;<code><em>i</em></code>&nbsp;天的股票价格 。​</p>
 *
 * <p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:</p>
 *
 * <ul>
 * <li>卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。</li>
 * </ul>
 *
 * <p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> prices = [1,2,3,0,2]
 * <strong>输出: </strong>3
 * <strong>解释:</strong> 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]</pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> prices = [1]
 * <strong>输出:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= prices.length &lt;= 5000</code></li>
 * <li><code>0 &lt;= prices[i] &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1731</li><li>👎 0</li></div>
 */
public class BestTimeToBuyAndSellStockWithCooldown309 {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown309().new Solution();
    }
    //这个题和714题一起看
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }
            int[] sell = new int[prices.length];
            int[] buy = new int[prices.length];
            buy[0] = -prices[0];
            sell[0] = 0;
            //buy[1]也是特殊处理，第一天买和第二天买中选择一个亏损最小的
            buy[1] = Math.max(-prices[0], -prices[1]);
            sell[1] = Math.max(sell[0], buy[0] + prices[1]);
            for (int i = 2; i < prices.length; i++) {
                //对于买，要么不买 就是延续上次买的利润不变，如果买，只能从上上次卖得利润基础上再买。因为有个冷冻期
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            }
            return sell[prices.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}