/**
 * <p>给你一个整数数组&nbsp;<code>nums</code>&nbsp;，如果&nbsp;<code>nums</code>&nbsp;<strong>至少</strong>&nbsp;包含&nbsp;<code>2</code>&nbsp;个元素，你可以执行以下操作：</p>
 *
 * <ul>
 * <li>选择 <code>nums</code>&nbsp;中的前两个元素并将它们删除。</li>
 * </ul>
 *
 * <p>一次操作的 <strong>分数</strong>&nbsp;是被删除元素的和。</p>
 *
 * <p>在确保<strong>&nbsp;所有操作分数相同</strong>&nbsp;的前提下，请你求出 <strong>最多</strong>&nbsp;能进行多少次操作。</p>
 *
 * <p>请你返回按照上述要求 <strong>最多</strong>&nbsp;可以进行的操作次数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 *
 * <pre>
 * <b>输入：</b>nums = [3,2,1,4,5]
 * <b>输出：</b>2
 * <b>解释：</b>我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,4,5] 。
 * - 删除前两个元素，分数为 1 + 4 = 5 ，nums = [5] 。
 * 由于只剩下 1 个元素，我们无法继续进行任何操作。</pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <b>输入：</b>nums = [3,2,6,1,4]
 * <b>输出：</b>1
 * <b>解释：</b>我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * 由于下一次操作的分数与前一次不相等，我们无法继续进行任何操作。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= nums.length &lt;= 100</code></li>
 * <li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>模拟</li></div></div><br><div><li>👍 15</li><li>👎 0</li></div>
 */
public class MaximumNumberOfOperationsWithTheSameScoreI3038 {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfOperationsWithTheSameScoreI3038().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxOperations(int[] nums) {
            if (nums.length < 2) {
                return 1;
            }

            int result = 1;
            //保存前两次操作和，不用每次都算一下
            int sum = nums[0] + nums[1];
            for (int i = 2; i < nums.length; i++) {
                if (i + 1 < nums.length && sum == nums[i] + nums[i + 1]) {
                    result++;
                    i++;
                } else {
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}