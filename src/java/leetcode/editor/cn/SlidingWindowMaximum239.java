import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2795 👎 0
 */
public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum239().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            //使用单调递减队列解决，队列只存访比
            LinkedList<Integer> deque = new LinkedList<>();
            //10个元素，窗口为4，结果是7，第一个窗口也是一个输出
            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                /* i>=k是先判断k是否越界（即是否为一个窗口）
               nums[i - k] == deque.peek() 检查队列头部元素，超过滑动窗口的范围要剔除,
                 */
                if (i >= k && nums[i - k] == deque.peek()) {
                    deque.poll();
                }
                //单调递减队列操作，保证队列的队首为最大值
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
                //因为在滑动窗口大小为k，而还没有达到滑动窗口大小时，不能添加
                if ((i + 1) >= k) {
                    result[i - k + 1] = deque.peek();
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}