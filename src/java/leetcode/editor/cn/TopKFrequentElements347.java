import java.util.*;
import java.util.stream.Stream;

/**
 * <p>给你一个整数数组 <code>nums</code> 和一个整数 <code>k</code> ，请你返回其中出现频率前 <code>k</code> 高的元素。你可以按 <strong>任意顺序</strong> 返回答案。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>nums = [1,1,1,2,2,3], k = 2
 * <strong>输出: </strong>[1,2]
 * </pre>
 *
 * <p><strong>示例 2:</strong></p>
 *
 * <pre>
 * <strong>输入: </strong>nums = [1], k = 1
 * <strong>输出: </strong>[1]</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>k</code> 的取值范围是 <code>[1, 数组中不相同的元素的个数]</code></li>
 * <li>题目数据保证答案唯一，换句话说，数组中前 <code>k</code> 个高频元素的集合是唯一的</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>进阶：</strong>你所设计算法的时间复杂度 <strong>必须</strong> 优于 <code>O(n log n)</code> ，其中 <code>n</code><em>&nbsp;</em>是数组大小。</p>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>分治</li><li>桶排序</li><li>计数</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 1849</li><li>👎 0</li></div>
 */
public class TopKFrequentElements347 {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements347().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            /*
            关于统计的类，首先想到的就是 哈希表，k为元素，value为次数；
            然后可以
             */
            Map<Integer, Integer> map = new HashMap<>();
            for (int key : nums) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            //使用优先级队列模拟大顶堆
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                    /*
                    b[1] - a[1] 表示比较两个元素的频次;
                    如果 b 的频次大于 a 的频次，则结果为正数，这意味着在优先级队列中 b 应该排在 a 的前面。
                    反之，如果 b 的频次小于 a，则结果为负数，a 应该排在 b 的前面。
                    这样就确保了优先级队列会按照元素频次的降序来排列。
                     */
                    (a, b) -> b[1] - a[1]
            );

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                //在add时，会满足上面的大顶堆 b[1] - a[1]的特性
                maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = maxHeap.poll()[0];
            }

            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}