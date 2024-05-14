import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠
 * 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= intervals.length <= 10⁵
 * intervals[i].length == 2
 * -5 * 10⁴ <= starti < endi <= 5 * 10⁴
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 排序 👍 1127 👎 0
 */
public class NonOverlappingIntervals435 {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals435().new Solution();
//        int i = solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
//        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            /*贪心算法
            确定局部最优解这里局部最优解找的是持续活动时间最早，需要注意的是先需要对 intervals[?][1]进行一个升序排序。
             */
            //按照最早结束排序
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

            int[] prev = intervals[0];
            int result = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] current = intervals[i];
                // 满足重叠区间，即 前一个节点的最大数量，不会超过 当前节点的最小数量
                if (current[0] >= prev[1]) {
                    prev = current;
                } else {
                    //不满足，则说明重叠了，汇总并返回
                    result++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}