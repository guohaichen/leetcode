/**
 * <p>在柠檬水摊上，每一杯柠檬水的售价为&nbsp;<code>5</code>&nbsp;美元。顾客排队购买你的产品，（按账单 <code>bills</code> 支付的顺序）一次购买一杯。</p>
 *
 * <p>每位顾客只买一杯柠檬水，然后向你付 <code>5</code> 美元、<code>10</code> 美元或 <code>20</code> 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 <code>5</code> 美元。</p>
 *
 * <p>注意，一开始你手头没有任何零钱。</p>
 *
 * <p>给你一个整数数组 <code>bills</code> ，其中 <code>bills[i]</code> 是第 <code>i</code> 位顾客付的账。如果你能给每位顾客正确找零，返回&nbsp;<code>true</code>&nbsp;，否则返回 <code>false</code>&nbsp;。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>bills = [5,5,5,10,20]
 * <strong>输出：</strong>true
 * <strong>解释：
 * </strong>前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>bills = [5,5,10,10,20]
 * <strong>输出：</strong>false
 * <strong>解释：</strong>
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= bills.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>bills[i]</code>&nbsp;不是&nbsp;<code>5</code>&nbsp;就是&nbsp;<code>10</code>&nbsp;或是&nbsp;<code>20</code>&nbsp;</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li></div></div><br><div><li>👍 607</li><li>👎 0</li></div>
 */
public class LemonadeChange860 {
    public static void main(String[] args) {
        Solution solution = new LemonadeChange860().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            /*
           题干 说 bills[i] 不是 5 就是 10 或是 20，那么我只需要记住5的数量，10的数量；
           当遇到5的时候，存一个5；
           当遇到10的时候，减一个5，加上一个10；
           遇到20的时候，减一个5，减少一个10，如果这两则都不够了，那么返回false
           (第一次思路，我上面的分析情况是错误的，因为20，可以找零 3个5，)
           所以需要额外再增加一次判断
             */
            int five = 0;
            int ten = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                } else if (bill == 10) {
                    ten++;
                    five--;
                    if (five < 0) {
                        return false;
                    }
                } else if (bill == 20) {
                    //这里five 和 ten 都大于0
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five = five - 3;
                    } else { //都小于0
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}