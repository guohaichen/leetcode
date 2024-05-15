import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10⁹
 * <p>
 * <p>
 * Related Topics 数学 动态规划 组合数学 👍 2025 👎 0
 */
public class UniquePaths62 {
    public static void main(String[] args) {
        Solution solution = new UniquePaths62().new Solution();
        System.out.println(uniquePath2(3, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 有规律 将第一行 第一列都设置为1，其他单元格的值为 其左边的行+上面的列的值相加 终点是哪个单元格，可以得出它到终点的路径为该值
        // 递推公式：(i,j) 处的走法等于(i-1,j) + (i,j-1) 的走法之和

        /**
         * @param m 行
         * @param n 列
         * @return 路径综合
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            //行
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            //列
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    /*降维到一维数组处理，节省空间
    0	1	1	1	1	1	1
    1	2	3	4	5	6	7
    1	3	6	10	15	21	28
     */
    public static int uniquePath2(int rows, int cols) {
        int[] dp = new int[cols];
        //先将第一排填充为1，公式为  dp[j] = dp[j]+dp[j-1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < rows; i++) {
            dp[0] = 1;
            for (int j = 1; j < cols; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[cols - 1];
    }
}