import java.util.HashSet;
import java.util.Set;

/**
 * <p>给定一个未排序的整数数组 <code>nums</code> ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。</p>
 *
 * <p>请你设计并实现时间复杂度为&nbsp;<code>O(n)</code><em> </em>的算法解决此问题。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [100,4,200,1,3,2]
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0,3,7,2,5,8,4,6,0,1]
 * <strong>输出：</strong>9
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>并查集</li><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 2134</li><li>👎 0</li></div>
 */
public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence128().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            //题目要求时间复杂度为o(n)，那么for暴力比如O n^2 超过题目要求；

            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int maxLength = 0;

            for (int num : nums) {
                //如果存在，说明num不是连续序列起点，跳过不处理，因为在遍历到处理num-1时num会被遍历，不必重复处理
                //如果不存在，说明没有比num小的数，num是连续序列的起点，继续向后遍历元素，并不断更新长度最大值
                if (!numSet.contains(num - 1)) {
                    int length = 1;
                    int temp = num + 1;
                    while (numSet.contains(temp)) {
                        temp+=1;
                        length+=1;
                    }
                    maxLength = Math.max(length, maxLength);

                }
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}