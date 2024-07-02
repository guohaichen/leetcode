import java.util.*;

/**
 * <p>给你一个字符串 <code>s</code> 和一个字符串列表 <code>wordDict</code> 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 <code>s</code>&nbsp;则返回 <code>true</code>。</p>
 *
 * <p><strong>注意：</strong>不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = "leetcode", wordDict = ["leet", "code"]
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = "applepenapple", wordDict = ["apple", "pen"]
 * <strong>输出:</strong> true
 * <strong>解释:</strong> 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * &nbsp;    注意，你可以重复使用字典中的单词。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * <strong>输出:</strong> false
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 300</code></li>
 * <li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * <li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
 * <li><code>s</code> 和 <code>wordDict[i]</code> 仅由小写英文字母组成</li>
 * <li><code>wordDict</code> 中的所有字符串 <strong>互不相同</strong></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字典树</li><li>记忆化搜索</li><li>数组</li><li>哈希表</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 2524</li><li>👎 0</li></div>
 */
public class WordBreak139 {
    public static void main(String[] args) {
        Solution solution = new WordBreak139().new Solution();
        List<String> dictWord = Arrays.asList("apple", "pen");
        solution.wordBreak("applepenapple", dictWord);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            /*
            思路，完全背包思考，s是背包，word是一个物品，求排列，能刚好满足背包大小，按照条件放入
             */
            Set<String> set = new HashSet<>(wordDict);
            //长度位s.length+1,
            boolean[] dp = new boolean[s.length() + 1];
            //dp 初始化，s.length >0 ，所以可以初始化为true
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {  //背包
                for (int j = 0; j < i; j++) {  //物品
                    // 如果s[j..i-1]在set中，并且s[0..j-1]可以被拆分，则s[0..i-1]也可以被拆分
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        //保证下次 dp[j] 为true
                        dp[i] = true;
                        //wordDict中所有的字符串互不相同，所以可以直接break;
                        break;
                    }
                }
            }
            return dp[s.length()];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}