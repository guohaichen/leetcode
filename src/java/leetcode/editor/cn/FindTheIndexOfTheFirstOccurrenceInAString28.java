/**
 * <p>给你两个字符串&nbsp;<code>haystack</code> 和 <code>needle</code> ，请你在 <code>haystack</code> 字符串中找出 <code>needle</code> 字符串的第一个匹配项的下标（下标从 0 开始）。如果&nbsp;<code>needle</code> 不是 <code>haystack</code> 的一部分，则返回&nbsp; <code>-1</code><strong> </strong>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>haystack = "sadbutsad", needle = "sad"
 * <strong>输出：</strong>0
 * <strong>解释：</strong>"sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>haystack = "leetcode", needle = "leeto"
 * <strong>输出：</strong>-1
 * <strong>解释：</strong>"leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= haystack.length, needle.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>haystack</code> 和 <code>needle</code> 仅由小写英文字符组成</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>双指针</li><li>字符串</li><li>字符串匹配</li></div></div><br><div><li>👍 2243</li><li>👎 0</li></div>
 */
public class FindTheIndexOfTheFirstOccurrenceInAString28 {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString28().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        简单的方法：
        几个核心的点：1. haystack 循环从0 ~ length-needle的长度即可.
        内存循环 j == needleArray.length时，匹配并返回i
         */
        public int strStr(String haystack, String needle) {
            char[] haystackArray = haystack.toCharArray();
            char[] needleArray = needle.toCharArray();
            if (needleArray.length > haystackArray.length) {
                return -1;
            }
            for (int i = 0; i <= haystackArray.length - needleArray.length; i++) {
                int j = 0;
                for (; j < needleArray.length; j++) {
                    if (needleArray[j] != haystackArray[j + i]) {
                        break;
                    }

                }
                //走到末尾了，全匹配
                if (j == needleArray.length) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}