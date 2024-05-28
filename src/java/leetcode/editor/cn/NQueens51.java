import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * <p>
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 9
 * <p>
 * <p>
 * Related Topics 数组 回溯 👍 2078 👎 0
 */
public class NQueens51 {
    public static void main(String[] args) {
        Solution solution = new NQueens51().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            //填充棋盘
            char[][] chessboard = new char[n][n];
            for (char[] c : chessboard) {
                Arrays.fill(c, '.');
            }
            //冲突列
            boolean[] cols = new boolean[n];
            //斜边冲突列
            boolean[] obliqueEdge = new boolean[2 * n - 1];
            //反斜边冲突列
            boolean[] reverseObliqueEdge = new boolean[2 * n - 1];
            backTracking(0, n, cols, obliqueEdge, reverseObliqueEdge, chessboard);
            return result;
        }

        private void backTracking(int i, int n, boolean[] cols, boolean[] obliqueEdge, boolean[] reverseObliqueEdge, char[][] chessboard) {
            // i棋盘的行，当然每行只能放一个皇后，可以得出递归条件 i = n 时，是一种解决方案。
            if (i == n) {
                List<String> list = new ArrayList<>();
                for (char[] chars : chessboard) {
                    list.add(String.valueOf(chars));
//                    System.out.println(list);
                }
                result.add(list);
//                System.out.println("------------------------------分割线-----------------------------------");
                return;
            }
            //j为列
            for (int j = 0; j < n; j++) {
                //冲突，也就是不能放置
                if (cols[j] || obliqueEdge[i + j] || reverseObliqueEdge[n - 1 - (i - j)]) {
                    continue;
                }
                //填充皇后
                chessboard[i][j] = 'Q';
                //冲突列,斜边冲突列,反斜边冲突列
                cols[j] = obliqueEdge[i + j] = reverseObliqueEdge[n - 1 - (i - j)] = true;
                //放置下一行的皇后
                backTracking(i + 1, n, cols, obliqueEdge, reverseObliqueEdge, chessboard);
                //回溯
                cols[j] = obliqueEdge[i + j] = reverseObliqueEdge[n - 1 - (i - j)] = false;
                chessboard[i][j] = '.';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}