import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 1548 👎 0
 */
public class CombinationSumIi40 {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi40().new Solution();
        List<List<Integer>> result = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            //先排序，将两相同的元素相邻
            Arrays.sort(candidates);
            backTracking(0, target, new boolean[candidates.length], candidates, new LinkedList<>(), result);
            return result;
            //和全排列2类似，因为结果要求的是元素不重复，而集合内的元素是可以重复的，所以可以先将集合进行排序，增加一个是否访问的属性
        }

        private void backTracking(int start, int target, boolean[] visited, int[] candidates, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            if (target < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                //判断元素是否相等，并且判断之前的元素是否被访问过
                if (i >= 1 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                    continue;
                }
                visited[i] = true;
                int candidate = candidates[i];
                stack.push(candidate);
                backTracking(i + 1, target - candidate, visited, candidates, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}