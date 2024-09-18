/**
 * <p>给定一个含有&nbsp;<code>n</code><strong>&nbsp;</strong>个正整数的数组和一个正整数 <code>target</code><strong> 。</strong></p>
 *
 * <p>找出该数组中满足其总和大于等于<strong> </strong><code>target</code><strong> </strong>的长度最小的 <strong><span data-keyword="subarray-nonempty">子数组</span></strong>&nbsp;<code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，并返回其长度<strong>。</strong>如果不存在符合条件的子数组，返回 <code>0</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 7, nums = [2,3,1,2,4,3]
 * <strong>输出：</strong>2
 * <strong>解释：</strong>子数组&nbsp;<span><code>[4,3]</code></span>&nbsp;是该条件下的长度最小的子数组。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 4, nums = [1,4,4]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>target = 11, nums = [1,1,1,1,1,1,1,1]
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= target &lt;= 10<sup>9</sup></code></li>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>如果你已经实现<em> </em><code>O(n)</code> 时间复杂度的解法, 请尝试设计一个 <code>O(n log(n))</code> 时间复杂度的解法。</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>前缀和</li><li>滑动窗口</li></div></div><br><div><li>👍 2226</li><li>👎 0</li></div>
 */
public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum209().new Solution();
        solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //目前是0n，核心是滑动窗口，在满足大于等于target的情况下，不断缩小左窗口的边界，当满足时，就判断最小的子数组长度
            int sum = 0;
            int n = nums.length;
            //res标记为n+1,或者Integer.max都可以；
            int res = n + 1;
            int left = 0;
            for (int right = 0; right < n; right++) {

                sum += nums[right];

                while (sum >= target) {
                    res = Math.min(res, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return res > n ? 0 : res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    //写在while循环外
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int sum = 0;
            int res = nums.length + 1;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum - nums[left] >= target) {
                    sum = sum - nums[left];
                    left++;

                }
                if (sum >= target) {
                    res = Integer.max(res, right - left + 1);
                }
            }

            return res > nums.length ? 0 : res;
        }
    }
}