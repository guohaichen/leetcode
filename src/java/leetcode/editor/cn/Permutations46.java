import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 2888 👎 0
 */
public class Permutations46 {
    public static void main(String[] args) {
        Solution solution = new Permutations46().new Solution();
        solution.permute(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //dfs
            dfs(nums, new boolean[nums.length], new LinkedList<Integer>(), result);
            System.out.println(Arrays.toString(result.toArray()));
            return result;
        }


        /**
         * 核心思路，排列的话 先固定第一个数，然后
         *
         * @param nums    需要全排列的数组[1,2,3]
         * @param visited 对应全排列的数组，存放的是 是否被访问过
         * @param stack
         * @param result  return
         */
        public void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
            //栈
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
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