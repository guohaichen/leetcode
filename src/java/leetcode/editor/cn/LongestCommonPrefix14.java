/**
 * <p>编写一个函数来查找字符串数组中的最长公共前缀。</p>
 *
 * <p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>strs = ["flower","flow","flight"]
 * <strong>输出：</strong>"fl"
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>strs = ["dog","racecar","car"]
 * <strong>输出：</strong>""
 * <strong>解释：</strong>输入不存在公共前缀。</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= strs.length &lt;= 200</code></li>
 * <li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
 * <li><code>strs[i]</code> 仅由小写英文字母组成</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字典树</li><li>字符串</li></div></div><br><div><li>👍 3129</li><li>👎 0</li></div>
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix14().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String result = strs[0];
            /*
            思路，将第一个字符串作为结果来逐一对比，每次和数组中的字符串对比，每次从下标0对比，如果不一致，则将下标记下来。
            将第一个字符串缩短为0-上一轮不一致的下标，进行下次对比，最后返回结果就是最长公共前缀,注意 subString(0,0)返回的是 ""
             */
            //i 为 字符数组下标
            for (int i = 1; i < strs.length; i++) {
                int index = 0;
                while (index < result.length() && index < strs[i].length()) {
                    if (result.charAt(index) != strs[i].charAt(index)) {
                        //减少循环次数
                        if (index == 0) {
                            return "";
                        }
                        break;
                    }
                    index++;
                }
                result = result.substring(0, index);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}