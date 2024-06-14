import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>给定一个非负索引 <code>rowIndex</code>，返回「杨辉三角」的第 <code>rowIndex</code><em>&nbsp;</em>行。</p>
 *
 * <p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>
 *
 * <p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> rowIndex = 3
 * <strong>输出:</strong> [1,3,3,1]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> rowIndex = 0
 * <strong>输出:</strong> [1]
 * </pre>
 *
 * <p><strong>示例 3:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> rowIndex = 1
 * <strong>输出:</strong> [1,1]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= rowIndex &lt;= 33</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <p>你可以优化你的算法到 <code><em>O</em>(<i>rowIndex</i>)</code> 空间复杂度吗？</p>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 545</li><li>👎 0</li></div>
 */
public class PascalsTriangleIi119 {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi119().new Solution();
        System.out.println(solution.getRow(5).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //        public List<Integer> getRow(int rowIndex) {
//            Integer[] dp = new Integer[rowIndex + 1];
//            //将dp所有元素填充为1
//            Arrays.fill(dp, 1);
//
//            //i次外循环，处理rowIndex每行的数据
//            for (int i = 1; i < rowIndex; i++) {
//                int pre = dp[0];
//                //核心思路就是 当前元素= 当前元素+上个元素
//                for (int j = 1; j <= i; j++) {
//                    //保存当前元素，作为下次的pre
//                    int cur = dp[j];
//                    dp[j] = cur + pre;
//                    //作为下次的pre
//                    pre = cur;
//                }
//            }
//            return Arrays.asList(dp);
//        }
        public List<Integer> getRow(int rowIndex) {
            int[] dp = new int[rowIndex + 1];
            List<Integer> result = new ArrayList<>();
            //i循环作为从上到下依次到 rowIndex的那行
            for (int i = 0; i <= rowIndex; i++) {
                //j循环用来根据上一行的值来计算本行的数据
                for (int j = i; j >= 0; j--) {
                    //初始化 对应着两边的值为1
                    if (j == 0 || j == i) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
            for (int i : dp) {
                result.add(i);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}