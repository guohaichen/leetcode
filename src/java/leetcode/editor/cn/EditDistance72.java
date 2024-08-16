/**
 * <p>给你两个单词&nbsp;<code>word1</code> 和&nbsp;<code>word2</code>， <em>请返回将&nbsp;<code>word1</code>&nbsp;转换成&nbsp;<code>word2</code> 所使用的最少操作数</em> &nbsp;。</p>
 *
 * <p>你可以对一个单词进行如下三种操作：</p>
 *
 * <ul>
 * <li>插入一个字符</li>
 * <li>删除一个字符</li>
 * <li>替换一个字符</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例&nbsp;1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>word1 = "horse", word2 = "ros"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>
 * horse -&gt; rorse (将 'h' 替换为 'r')
 * rorse -&gt; rose (删除 'r')
 * rose -&gt; ros (删除 'e')
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>word1 = "intention", word2 = "execution"
 * <strong>输出：</strong>5
 * <strong>解释：</strong>
 * intention -&gt; inention (删除 't')
 * inention -&gt; enention (将 'i' 替换为 'e')
 * enention -&gt; exention (将 'n' 替换为 'x')
 * exention -&gt; exection (将 'n' 替换为 'c')
 * exection -&gt; execution (插入 'u')
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
 * <li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 3447</li><li>👎 0</li></div>
 */
public class EditDistance72 {
    public static void main(String[] args) {
        Solution solution = new EditDistance72().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*dp先设定
            dp[i][j]表示word1中的第一个字符与word2中第j个字符，转变成相等需要最少得操作距离；
                    h   o   r   s   e
                0   1   2   3   4   5
           r    1
           o    2
           s    3
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            //边界条件
            //当 i=0 时，表示 word1 是空串，要变成 word2 的前 j 个字符，只能通过插入 j 个字符实现，所以 dp[0][j] = j。
            //当 j=0 时，表示 word2 是空串，要变成 word1 的前 i 个字符，只能通过删除 i 个字符实现，所以 dp[i][0] = i。
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    //两个字符相等，那么不用做什么 增删改操作，保留上次两个字符对比的结果
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    //如果不等，则要在增、删、改操作中选择一个 最少操作次数的+1；
                    //替换：dp[i][j] = dp[i-1][j-1] + 1
                    //插入：dp[i][j] = dp[i][j-1] + 1
                    //删除：dp[i][j] = dp[i-1][j] + 1
                    //在三种操作中选择操作次数中的+1
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}