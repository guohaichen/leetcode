/**
 * <p>给你一个整数数组 <code>nums</code> ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>
 *
 * <p><strong><span data-keyword="subarray-nonempty">子数组 </span></strong>是数组中的一个连续部分。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-2,1,-3,4,-1,2,1,-5,4]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [5,4,-1,7,8]
 * <strong>输出：</strong>23
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>如果你已经实现复杂度为 <code>O(n)</code> 的解法，尝试使用更为精妙的 <strong>分治法</strong> 求解。</p>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>动态规划</li></div></div><br><div><li>👍 6708</li><li>👎 0</li></div>
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray53().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //化简后
        public int maxSubArray(int[] nums) {

            int pre = 0;
            int max = nums[0];

            for (int num : nums) {
                //pre+num为连续，       num为不连续，说明之前的pre反而变小了，所以不需要
                pre = Integer.max(pre + num, num);

                max = Integer.max(max, pre);
            }
            return max;
        }
        //标准动态规划
       /* public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            //初始化dp，注意的是 最后 不是返回dp[length-1],最大子数组
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < nums.length; i++) {
                // dp[i - 1] + nums[i] 表示连续的子数组，
                dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
                max = Integer.max(dp[i], max);
            }
            return max;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}