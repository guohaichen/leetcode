/**
 * <p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的 <span data-keyword="palindromic-string">回文</span> <span data-keyword="substring-nonempty">子串</span>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "babad"
 * <strong>输出：</strong>"bab"
 * <strong>解释：</strong>"aba" 同样是符合题意的答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "cbbd"
 * <strong>输出：</strong>"bb"
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> 仅由数字和英文字母组成</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 7231</li><li>👎 0</li></div>
 */
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            //中心扩散法，我在字符数组中找到一个中心点，然后利用双指针分别左右移动并判断，

            char[] str = s.toCharArray();

            for (int i = 0; i < str.length - 1; i++) {
                // 一个字符作为中心扩散点
                longest(str, i, i);
                //两个字符作为中序扩散点
                longest(str, i, i + 1);
            }
            return s.substring(left, right + 1);


        }

        int left;
        int right;

        public void longest(char[] str, int i, int j) {
            //判断边界条件,i是left j是right
            while (i >= 0 && j < str.length && str[i] == str[j]) {
                i--;
                j++;
            }
            //上面的条件是回文，当退出while时候说明不是回文了，这里计算满足回文的长度，
            i++;
            j--;
            if ((right - left + 1) < (j - i + 1)) {
                left = i;
                right = j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}