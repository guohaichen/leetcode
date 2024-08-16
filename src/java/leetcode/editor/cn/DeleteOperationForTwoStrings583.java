/**
 * <p>给定两个单词&nbsp;<code>word1</code>&nbsp;和
 * <meta charset="UTF-8" />&nbsp;<code>word2</code>&nbsp;，返回使得
 * <meta charset="UTF-8" />&nbsp;<code>word1</code>&nbsp;和&nbsp;
 * <meta charset="UTF-8" />&nbsp;<code>word2</code><em>&nbsp;</em><strong>相同</strong>所需的<strong>最小步数</strong>。</p>
 *
 * <p><strong>每步&nbsp;</strong>可以删除任意一个字符串中的一个字符。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> word1 = "sea", word2 = "eat"
 * <strong>输出:</strong> 2
 * <strong>解释:</strong> 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * </pre>
 *
 * <p><strong>示例 &nbsp;2:</strong></p>
 *
 * <pre>
 * <b>输入：</b>word1 = "leetcode", word2 = "etco"
 * <b>输出：</b>4
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 * <meta charset="UTF-8" />
 *
 * <ul>
 * <li><code>1 &lt;= word1.length, word2.length &lt;= 500</code></li>
 * <li><code>word1</code>&nbsp;和&nbsp;<code>word2</code>&nbsp;只包含小写英文字母</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 685</li><li>👎 0</li></div>
 */
public class DeleteOperationForTwoStrings583 {
    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings583().new Solution();
    }


    //和力扣72题编辑距离类似；

    /*
                s   e   a
            0
        e
        a
        t
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }


            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    //相等则不需要改动，保留上次操作结果
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //删除i，删除j,或者两个都删除的情况中选择最小
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}