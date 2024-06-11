import java.nio.charset.StandardCharsets;

/**
 * <p>给你一个整数 <code>x</code> ，如果 <code>x</code> 是一个回文整数，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
 *
 * <p><span data-keyword="palindrome-integer">回文数</span>是指正序（从左向右）和倒序（从右向左）读都是一样的整数。</p>
 *
 * <ul>
 * <li>例如，<code>121</code> 是回文，而 <code>123</code> 不是。</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>x = 121
 * <strong>输出：</strong>true
 * </pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>x = -121
 * <strong>输出：</strong>false
 * <strong>解释：</strong>从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>x = 10
 * <strong>输出：</strong>false
 * <strong>解释：</strong>从右向左读, 为 01 。因此它不是一个回文数。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup>&nbsp;&lt;= x &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你能不将整数转为字符串来解决这个问题吗？</p>
 *
 * <div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 2852</li><li>👎 0</li></div>
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber9().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            /*转换成字符串，字节数组的做法，头尾比较，如果不一样则返回false；
            String str = String.valueOf(x);
            byte[] bytes = str.getBytes();

            int length = bytes.length - 1;

            for (int i = 0; i < bytes.length / 2; i++) {
                if (bytes[i] != bytes[length--]) {
                    return false;
                }
            }
            return true;
            */


            /* 方便一点的字符串反转
            String str = String.valueOf(x);
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equals(reversed);*/

            //数学的方法，对x 模10求余。reversed每次*10+这个余数，其实就反转了整个数字
            int original = x;
            int reversed = 0;
            while (x > 0) {
                reversed = reversed * 10 + x % 10;
                x = x / 10;
            }
            return reversed == original;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}