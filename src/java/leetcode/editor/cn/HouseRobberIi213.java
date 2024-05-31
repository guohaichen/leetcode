import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
 * 装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 1595 👎 0
 */
public class HouseRobberIi213 {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi213().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            /*
            首尾相连，可以分成两种情况:
            偷第一间，最后一间不偷；
            不偷第一件，最后一间偷；
            对比两种情况的最大价值
             */
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            //注意copyOfRange 是左开右闭
            return Math.max(
                    rob2(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                    rob2(Arrays.copyOfRange(nums, 1, nums.length)));
        }

        public int rob2(int[] nums) {
            nums[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
            }
            return nums[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}