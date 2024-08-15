import java.util.Arrays;

/**
 * <p>给定两个字符串&nbsp;<code>text1</code> 和&nbsp;<code>text2</code>，返回这两个字符串的最长 <strong>公共子序列</strong> 的长度。如果不存在 <strong>公共子序列</strong> ，返回 <code>0</code> 。</p>
 *
 * <p>一个字符串的&nbsp;<strong>子序列</strong><em>&nbsp;</em>是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。</p>
 *
 * <ul>
 * <li>例如，<code>"ace"</code> 是 <code>"abcde"</code> 的子序列，但 <code>"aec"</code> 不是 <code>"abcde"</code> 的子序列。</li>
 * </ul>
 *
 * <p>两个字符串的 <strong>公共子序列</strong> 是这两个字符串所共同拥有的子序列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abcde", text2 = "ace"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长公共子序列是 "ace" ，它的长度为 3 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abc", text2 = "abc"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>最长公共子序列是 "abc" ，它的长度为 3 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>text1 = "abc", text2 = "def"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>两个字符串没有公共子序列，返回 0 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li>
 * <li><code>text1</code> 和&nbsp;<code>text2</code> 仅由小写英文字符组成。</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 1599</li><li>👎 0</li></div>
 */
public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence1143().new Solution();
        solution.longestCommonSubsequence("ezupkr", "ubmrapg");
    }

    /*
    子序列问题，
        di[i][j]
            a   b   c   d   e
        a   1   1   1   1   1
        c   1   1   2   2   2
        e   1   1   2   2   3

       dp[i][j] = 如果 字符串相等则取 dp[i-1][j-1]+1;
       如果不等则选择Integer.max(dp[i - 1][j], dp[i][j-1]);
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int longestCommonSubsequence(String text1, String text2) {
//            int m = text1.length();
//            int n = text2.length();
//            int[][] dp = new int[m + 1][n + 1];
//            for (int i = 1; i <= m; i++) {
//                char s1 = text1.charAt(i - 1);
//                for (int j = 1; j <= n; j++) {
//                    //相等
//                    if (s1 == text2.charAt(j - 1)) {
//                        dp[i][j] = dp[i - 1][j - 1] + 1;
//                    } else {
//                        dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
//                    }
//                }
//            }
//            return dp[m][n];
//        }
        //降维
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            int[] dp = new int[n + 1];

            for (int i = 1; i <= m; i++) {
                //初始时，dp[0]为 0;
                int prev = 0;
                for (int j = 1; j <= n; j++) {
                    int cur = dp[j];
                    //相等
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        // perv为上一轮的dp[j]
                        dp[j] = prev + 1;
                    } else {
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                    }
                    prev = cur;
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}