/**
 * 给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回子数组内所有元素的乘积严格小于<em> </em><code>k</code> 的连续子数组的数目。
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [10,5,2,6], k = 100
 * <strong>输出：</strong>8
 * <strong>解释：</strong>8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3], k = 0
 * <strong>输出：</strong>0</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:&nbsp;</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= k &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>滑动窗口</li></div></div><br><div><li>👍 801</li><li>👎 0</li></div>
 */
public class SubarrayProductLessThanK713 {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK713().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            //题目要求是 1 <= nums[i] <= 1000
            if (k <= 1) {
                return 0;
            }
            int ans = 0;
            int left = 0;
            int mul = 1;
            for (int right = 0; right < nums.length; right++) {
                mul *= nums[right];
                //当乘积大于k时，应该缩小窗口。不断地调整左窗口
                while (mul >= k) {
                    mul = mul / nums[left];
                    left++;
                }
                //当窗口内的乘积满足小于 k 的条件时，说明从 left 到 right 之间的所有子数组（包括 right 本身）都是有效的子数组，因此将窗口的长度 right - left + 1 加入结果 ans 中。
                ans += right - left + 1;
            }
            return ans;
            //滑动窗口
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}