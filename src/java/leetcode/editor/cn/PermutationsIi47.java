import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 1567 👎 0
 */
public class PermutationsIi47 {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi47().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
        /*
        全排列2，对比全排列的话就是先需要将已知的nums进行排序，目得是为将相同的元素相邻；
         */
            //先排序
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> stack = new LinkedList<>();
            dfs(nums, new boolean[nums.length], stack, result);
            return result;
        }

        private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                //判断相邻元素是否相等，
                if (i > 0 && nums[i] == nums[i - 1]) {
                    //当相同时，查看之前的数是否被访问过，没有的话跳过
                    if (!visited[i - 1]) {
                        //跳过本次
                        continue;
                    }
                }
                //没有被访问过
                if (!visited[i]) {
                    stack.push(nums[i]);
                    visited[i] = true;
                    dfs(nums, visited, stack, result);
                    //回溯
                    visited[i] = false;
                    stack.pop();
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}