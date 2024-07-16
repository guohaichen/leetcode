import java.util.Arrays;

/**
 * <p>给你一个整数数组 <code>nums</code> 和一个整数&nbsp;<code>k</code> ，请你统计并返回 <em>该数组中和为&nbsp;<code>k</code><strong>&nbsp;</strong>的子数组的个数&nbsp;</em>。</p>
 *
 * <p>子数组是数组中元素的连续非空序列。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,1,1], k = 2
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3], k = 3
 * <strong>输出：</strong>2
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>前缀和</li></div></div><br><div><li>👍 2404</li><li>👎 0</li></div>
 */
public class SubarraySumEqualsK560 {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK560().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {

                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        result++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}