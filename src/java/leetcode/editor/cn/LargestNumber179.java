import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>给定一组非负整数 <code>nums</code>，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。</p>
 *
 * <p><strong>注意：</strong>输出结果可能非常大，所以你需要返回一个字符串而不是整数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入<code>：</code></strong><span><code>nums = [10,2]</code></span>
 * <strong>输出：</strong><span><code>"210"</code></span></pre>
 *
 * <p><strong>示例&nbsp;2：</strong></p>
 *
 * <pre>
 * <strong>输入<code>：</code></strong><span><code>nums = [3,30,34,5,9]</code></span>
 * <strong>输出：</strong><span><code>"9534330"</code></span>
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 1290</li><li>👎 0</li></div>
 */
public class LargestNumber179 {
    public static void main(String[] args) {
        Solution solution = new LargestNumber179().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] numbers = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numbers[i] = String.valueOf(nums[i]);
            }

            //利用比较器排序，因为是升序，所以这里改为(o2+o1).compareTo(o1+o2)，所以大的就可以排在前面了
            Arrays.sort(
                    numbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2)
            );
            //以0 开头，后面也就是0，直接返回0即可
            if (numbers[0].equals("0")){
                return "0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String number : numbers) {
                stringBuilder.append(number);
            }

            return String.valueOf(stringBuilder);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}