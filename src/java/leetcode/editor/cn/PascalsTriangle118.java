import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>给定一个非负整数&nbsp;<em><code>numRows</code>，</em>生成「杨辉三角」的前&nbsp;<em><code>numRows</code>&nbsp;</em>行。</p>
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
 * <strong>输入:</strong> numRows = 5
 * <strong>输出:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * </pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> numRows = 1
 * <strong>输出:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= numRows &lt;= 30</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 1166</li><li>👎 0</li></div>
 */
public class PascalsTriangle118 {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle118().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> result = new ArrayList<>();
            //i对应行数，j是每行的具体计算，j的值取决于上一行的值
            for (int i = 0; i < numRows; i++) {
                List<Integer> levelList = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    //设置两边为1
                    if (j == 0 || j == i) {
                        levelList.add(1);
                    } else {
                        //cur的值 = 上一行 i-1，j-1的值 + i-1 +j 的值
                        int cur = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                        levelList.add(cur);
                    }
                }
                result.add(levelList);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}