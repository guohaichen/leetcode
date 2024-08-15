import java.util.Arrays;

/**
 * <p>给两个整数数组&nbsp;<code>nums1</code>&nbsp;和&nbsp;<code>nums2</code>&nbsp;，返回 <em>两个数组中 <strong>公共的</strong> 、长度最长的子数组的长度&nbsp;</em>。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * <strong>输出：</strong>3
 * <strong>解释：</strong>长度最长的公共子数组是 [3,2,1] 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * <strong>输出：</strong>5
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
 * <li><code>0 &lt;= nums1[i], nums2[i] &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>动态规划</li><li>滑动窗口</li><li>哈希函数</li><li>滚动哈希</li></div></div><br><div><li>👍 1103</li><li>👎 0</li></div>
 */
public class MaximumLengthOfRepeatedSubarray718 {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray718().new Solution();
        solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 1, 4, 7});
    }

    /*
            1   2   3   2   1
        3   0   0   1   0   0
        2   0   1   0   2   0
        1   1   0   0   0   3
        1   1   0   0   0   1
        4   0   0   0   0   0
        7   0   0   0   0   0
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public int findLength(int[] nums1, int[] nums2) {
//            int m = nums1.length;
//            int n = nums2.length;
//            int[][] dp = new int[m][n];
//
//            int max = 0;
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (nums1[i] == nums2[j]) {
//                        if (i == 0 || j == 0) {
//                            dp[i][j] = 1;
//                        } else {
//                            dp[i][j] = dp[i - 1][j - 1] + 1;
//                        }
//                        max = Integer.max(max, dp[i][j]);
//                    } else {
//                        dp[i][j] = 0;
//                    }
//                }
//            }
//            return max;
//        }
        public int findLength(int[] nums1, int[] nums2) {
            //降维
            int[] dp = new int[nums2.length];
            int max = 0;
            for (int i = 0; i < nums1.length; i++) {
                //j的索引要从大到小，因为它的对应值需要用到 i-1行的 小索引，不能使用当前i的索引。
                for (int j = nums2.length - 1; j >= 0; j--) {

                    if (nums1[i] == nums2[j]) {
                        if (i == 0 || j == 0) {
                            dp[j] = 1;
                        } else {
                            dp[j] = dp[j - 1] + 1;
                        }
                        max = Integer.max(dp[j], max);
                    } else {
                        dp[j] = 0;
                    }
                }
//                System.out.println("--" + Arrays.toString(dp));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}