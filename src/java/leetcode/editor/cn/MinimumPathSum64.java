import java.util.Arrays;

/**
 * <p>给定一个包含非负整数的 <code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;网格&nbsp;<code>grid</code> ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>
 *
 * <p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong class="example">示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>输入：</strong>grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <strong>输出：</strong>7
 * <strong>解释：</strong>因为路径 1→3→1→1→1 的总和最小。
 * </pre>
 *
 * <p><strong class="example">示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>grid = [[1,2,3],[4,5,6]]
 * <strong>输出：</strong>12
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>m == grid.length</code></li>
 * <li><code>n == grid[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 200</code></li>
 * <li><code>0 &lt;= grid[i][j] &lt;= 200</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 1688</li><li>👎 0</li></div>
 */
public class MinimumPathSum64 {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum64().new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}};
        System.out.println(solution.minPathSum(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            /*
            思路： 动态规划，先把0行0列填充出来，后续的最小路径总和 即为 min(上一步，左一步）+当前路径
            和最短路径有点类似，每次只能向下或者向右移动1步；
             */
            int row = grid.length;
            int cols = grid[0].length;
            int[][] dp = new int[row][cols];

            dp[0][0] = grid[0][0];

            for (int i = 1; i < row; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }

            for (int i = 1; i < cols; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }


            for (int i = 1; i < row; i++) {
                for (int j = 1; j < cols; j++) {
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[row - 1][cols - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}