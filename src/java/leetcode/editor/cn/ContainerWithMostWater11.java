/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 2 <= n <= 10⁵
 * 0 <= height[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 👍 4988 👎 0
 */
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater11().new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 算容量： 水的容量 = 最低的桶 * 宽度
            //双指针移动，先不管线的高度，宽度越宽，则水装的越多；最宽为0-length-1；然后再移动线低的一边
            int left = 0;
            int right = height.length - 1;
            int max = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    max = Math.max(max, height[left] * (right - left));

                    left++;
                } else if (height[left] >= height[right]) {
                    max = Math.max(max, height[right] * (right - left));
                    right--;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}