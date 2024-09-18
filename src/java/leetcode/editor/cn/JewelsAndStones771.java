/**
 * <p>&nbsp;给你一个字符串 <code>jewels</code>&nbsp;代表石头中宝石的类型，另有一个字符串 <code>stones</code> 代表你拥有的石头。&nbsp;<code>stones</code>&nbsp;中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。</p>
 *
 * <p>字母区分大小写，因此 <code>"a"</code> 和 <code>"A"</code> 是不同类型的石头。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>jewels = "aA", stones = "aAAbbbb"
 * <strong>输出：</strong>3
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>jewels = "z", stones = "ZZ"
 * <strong>输出：</strong>0<strong>
 * </strong></pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;=&nbsp;jewels.length, stones.length &lt;= 50</code></li>
 * <li><code>jewels</code> 和 <code>stones</code> 仅由英文字母组成</li>
 * <li><code>jewels</code> 中的所有字符都是 <strong>唯一的</strong></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 817</li><li>👎 0</li></div>
 */
public class JewelsAndStones771 {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones771().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            int count = 0;
            for (char c : stones.toCharArray()) {
                if (jewels.indexOf(c) >= 0) {
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}