import java.util.ArrayList;
import java.util.List;

/**
 * <p>给你一个整数数组&nbsp;<code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的<span data-keyword="subset">子集</span>（幂集）。</p>
 *
 * <p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3]
 * <strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0]
 * <strong>输出：</strong>[[],[0]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10</code></li>
 * <li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
 * <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>回溯</li></div></div><br><div><li>👍 2318</li><li>👎 0</li></div>
 */
public class Subsets78 {
    public static void main(String[] args) {
        Solution solution = new Subsets78().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtracking(0, nums);
            return result;
        }

        //子集问题，也就是选与不选，那么当前元素有两种情况，选择和不选择
        private void backtracking(int startIndex, int[] nums) {

            if (startIndex == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }
            //不选择当前元素
            backtracking(startIndex + 1, nums);
            path.add(nums[startIndex]);



            backtracking(startIndex + 1, nums);
            //还原
            path.remove(path.size() - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}