/**
 * <p>给定一个整数数组&nbsp;<code>prices</code>，其中 <code>prices[i]</code>表示第&nbsp;<code>i</code>&nbsp;天的股票价格 ；整数&nbsp;<code>fee</code> 代表了交易股票的手续费用。</p>
 *
 * <p>你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。</p>
 *
 * <p>返回获得利润的最大值。</p>
 *
 * <p><strong>注意：</strong>这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>prices = [1, 3, 2, 8, 4, 9], fee = 2
 * <strong>输出：</strong>8
 * <strong>解释：</strong>能够达到的最大利润:
 * 在此处买入&nbsp;prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:&nbsp;((8 - 1) - 2) + ((9 - 4) - 2) = 8</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>prices = [1,3,7,5,10,3], fee = 3
 * <strong>输出：</strong>6
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= prices.length &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= prices[i] &lt; 5 * 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= fee &lt; 5 * 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1058</li><li>👎 0</li></div>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee714 {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee714().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            /*定义买卖两个数组
            之前 dp table 都是一个数组，这里两个数组因为买卖是有依赖关系；
             */
            int[] sell = new int[prices.length];
            int[] buy = new int[prices.length];
            /*
            对于买：
            1. 延续上次的买的利润不变；
            2. 在上次卖的利润基础上再买；
            对于卖:
            1. 延续上次卖的利润不变；
            2. 在上次买的利润基础上再卖
             */
            buy[0] = -prices[0];
            sell[0] = 0;
            for (int i = 1; i < prices.length; i++) {
                buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            }

            return sell[prices.length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}