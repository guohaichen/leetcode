import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * <p>
 * <p>
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 852 👎 0
 */
public class CombinationSumIii216 {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii216().new Solution();
        solution.combinationSum3(3, 9);
        System.out.println(count);
    }

    static private int count;

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            LinkedList<Integer> stack = new LinkedList<>();

            backTracking(1, k, n, stack, result);
            for (List<Integer> list : result) {
                System.out.println(list);
            }
            return result;
        }

        private void backTracking(int start, int k, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
//            count++;
            if (target == 0 && k == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i <= 9; i++) {
                if (target < i) {
                    continue;
                }
                if (k < 0) {
                    continue;
                }
                stack.push(i);
                k--;
                backTracking(i + 1, k, target - i, stack, result);
                k++;
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}