import java.util.Arrays;

/**
 * <p>给你一个整数数组 <code>nums</code> ，找到其中最长严格递增子序列的长度。</p>
 *
 * <p><strong>子序列&nbsp;</strong>是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，<code>[3,6,2,7]</code> 是数组 <code>[0,3,1,6,2,2,7]</code> 的<span data-keyword="subsequence-array">子序列</span>。</p> &nbsp;
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [10,9,2,5,3,7,101,18]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,1,0,3,2,3]
 * <strong>输出：</strong>4
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [7,7,7,7,7,7,7]
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2500</code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><b>进阶：</b></p>
 *
 * <ul>
 * <li>你能将算法的时间复杂度降低到&nbsp;<code>O(n log(n))</code> 吗?</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>动态规划</li></div></div><br><div><li>👍 3658</li><li>👎 0</li></div>
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence300().new Solution();
        solution.lengthOfLIS(new int[]{1, 3, 6, 4, 9, 7, 8,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
        /*
        dp[]中默认都先认为当前元素是一个子序列，填充为1；
        dp[i]代表以i结尾的最大递增子序列，如何找到：从以nums【0】,nums[1]...nums[i-1] 和nums[i]+1中比较 找到最大值得到(首要条件是满足递增)
         */
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    //递增
                    if (nums[i] > nums[j]) {
                        /*dp[j]+1 因为当前 nums[i]是满足递增的条件，所以需要+1，例如 0 3 2 4 当前元素nums[i]为5
                        那么需要判断 以5为结尾的最大递增子序列，之前的dp如下：{1,2,2,3},
                        j 从 0 ~ 3 对比，
                         */
                        dp[i] = Integer.max(dp[i], dp[j] + 1);
                    }
                }
                System.out.println(Arrays.toString(dp));
            }
            //注意返回值 是 返回dp中最大值，而不是最后一个元素，最大子序列可能不是最后一个元素构成
            return Arrays.stream(dp).max().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}