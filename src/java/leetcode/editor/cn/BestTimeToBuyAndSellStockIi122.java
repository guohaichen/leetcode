/**
 * <p>给你一个整数数组 <code>prices</code> ，其中&nbsp;<code>prices[i]</code> 表示某支股票第 <code>i</code> 天的价格。</p>
 *
 * <p>在每一天，你可以决定是否购买和/或出售股票。你在任何时候&nbsp;<strong>最多</strong>&nbsp;只能持有 <strong>一股</strong> 股票。你也可以先购买，然后在 <strong>同一天</strong> 出售。</p>
 *
 * <p>返回 <em>你能获得的 <strong>最大</strong> 利润</em>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>prices = [7,1,5,3,6,4]
 * <strong>输出：</strong>7
 * <strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * &nbsp;    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>prices = [1,2,3,4,5]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * &nbsp;    总利润为 4 。</pre>
 *
 * <p><strong>示例&nbsp;3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>prices = [7,6,4,3,1]
 * <strong>输出：</strong>0
 * <strong>解释：</strong>在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= prices.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 2489</li><li>👎 0</li></div>
 */
public class BestTimeToBuyAndSellStockIi122 {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi122().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            //买入指针
            int i = 0;
            //卖出指针
            int j = 1;
            int result = 0;

            while (j < prices.length) {
                //涨
                if (prices[j] - prices[i] > 0) {
                    result += prices[j] - prices[i];
                }
                //卖出当天就可以买入
                i = j;
                j++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}