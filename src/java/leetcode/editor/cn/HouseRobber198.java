/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小
 * 偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 2989 👎 0
 */
public class HouseRobber198 {
    public static void main(String[] args) {
        Solution solution = new HouseRobber198().new Solution();
        System.out.println(solution.rob(new int[]{4, 1, 3, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
        /*
        每个房间两个选择，偷与不偷，不偷的情况：当前房间的价值没有上个房间的价值高，如果偷则当前房间的价值高。同时将房间的价值写入 dp[i] = value;
        当只有一个房间时，最大价值为 dp[0]
        当有两个房间时，最大价值为 max(dp[1-1],dp[1]);
        当有3个房间时，判断当前偷与不偷：偷:dp[i-2]+dp[i]>dp[i-1]
        不偷：dp[i-2]+dp[i]<dp[i-1],即当前房间的价值为 max(dp[i-2],dp[i]>dp[i-1])
        举个例子： 7，2，1，3；第二个房间的价值仍然为7，第一个房间的价值7+第四个房间的价值3 =10；
         */
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            nums[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                nums[i] = Math.max((nums[i] + nums[i - 2]), nums[i - 1]);
            }
            return nums[length - 1];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}