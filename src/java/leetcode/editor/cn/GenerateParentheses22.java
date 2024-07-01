import java.util.ArrayList;
import java.util.List;

/**
 * <p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 3
 * <strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>n = 1
 * <strong>输出：</strong>["()"]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 8</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li><li>回溯</li></div></div><br><div><li>👍 3608</li><li>👎 0</li></div>
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses22().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        思路 : 卡特兰数算是一种解决方案
        另外一种：dfs
         */
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(result, "", n, n);
            return result;
        }

        /**
         * @param result  最后的结果
         * @param current 当前的括号组合
         * @param left    （
         * @param right   ）
         */
        private void dfs(List<String> result, String current, int left, int right) {
            if (left == 0 && right == 0) {
                result.add(current);
                return;
            }
            if (left > 0) {
                dfs(result, current + "(", left - 1, right);
            }
            // 右括号的数量大于左括号的数量
            if (right > left) {
                dfs(result, current + ")", left, right - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}