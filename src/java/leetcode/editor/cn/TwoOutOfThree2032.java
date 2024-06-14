import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你三个整数数组 <code>nums1</code>、<code>nums2</code> 和 <code>nums3</code> ，请你构造并返回一个 <strong>元素各不相同的</strong> 数组，且由 <strong>至少</strong> 在 <strong>两个</strong> 数组中出现的所有值组成<em>。</em>数组中的元素可以按 <strong>任意</strong> 顺序排列。
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * <strong>输出：</strong>[3,2]
 * <strong>解释：</strong>至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * <strong>输出：</strong>[2,3,1]
 * <strong>解释：</strong>至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * <strong>输出：</strong>[]
 * <strong>解释：</strong>不存在至少在两个数组中出现的值。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums1.length, nums2.length, nums3.length &lt;= 100</code></li>
 * <li><code>1 &lt;= nums1[i], nums2[j], nums3[k] &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>哈希表</li></div></div><br><div><li>👍 86</li><li>👎 0</li></div>
 */
public class TwoOutOfThree2032 {
    public static void main(String[] args) {
        Solution solution = new TwoOutOfThree2032().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            // k对应数字，value 表示存在于哪个数组；
            // 一个数组中可能存在相同的数组，但是他们并不算出现在两个数组中出现的值，所以需要额外判断一下不能是当前数组
            for (int i : nums1) {
                map.put(i, 0);
            }
            for (int i : nums2) {
                if (map.containsKey(i) && map.get(i)!=1) {
                    //没有包含，相同的结果不添加
                    if (!result.contains(i)) {
                        result.add(i);
                    }
                } else {
                    map.put(i, 1);
                }
            }
            for (int i : nums3) {
                if (map.containsKey(i) && map.get(i)!=2) {
                    if (!result.contains(i)) {
                        result.add(i);
                    }
                } else {
                    map.put(i, 2);
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}