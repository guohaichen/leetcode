import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * Related Topics 回溯 👍 1627 👎 0
 */
public class Combinations77 {
    public static void main(String[] args) {
        Solution solution = new Combinations77().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();

            dfs(n, k, 1, new LinkedList<>(), result);
            return result;
        }

        /**
         * @param n      1-n
         * @param k      组合个数
         * @param start  n开始位置
         * @param stack
         * @param result
         */
        private void dfs(int n, int k, int start, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (k == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            // i=start 排除已经给出的组合
            for (int i = start; i <= n; i++) {
                //想一想可不可以进行减枝操作。 n-i+1 代表什么含义；k个数; n-i+1 代表剩余可用数字的个数
                //剪枝操作，减少不必要的回溯
                if (k > n - i + 1) {
                    continue;
                }
                stack.push(i);
                dfs(n, k - 1, i + 1, stack, result);
                //回溯
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}