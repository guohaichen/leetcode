/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元
 * 素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10⁹ <= nums1[i], nums2[j] <= 10⁹
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * <p>
 * Related Topics 数组 双指针 排序 👍 2412 👎 0
 */
public class MergeSortedArray88 {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray88().new Solution();
    }
    //偷懒的做法就是 将 nums2的元素追加到nums1，然后快排
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 定义双指针，分别指向两个数组的末尾
            int i = m - 1; // 指向 nums1 的最后一个有效元素
            int j = n - 1; // 指向 nums2 的最后一个有效元素

            // 从数组末尾开始比较并合并，经典在于下标的处理，i+j+1
            while (i >= 0 && j >= 0) {
                if (nums1[i] <= nums2[j]) {
                    nums1[i + j + 1] = nums2[j];
                    j--;
                } else {
                    nums1[i + j + 1] = nums1[i];
                    i--;
                }
            }

            // 如果 nums2 还有剩余元素，直接将其追加到 nums1 后面
            while (j >= 0) {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}