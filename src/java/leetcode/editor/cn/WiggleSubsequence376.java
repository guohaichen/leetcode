/**
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作
 * 摆动序列。
 * <p>
 * <p>
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差
 * 值为零。
 * <p>
 * <p>
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度完成此题?
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 1118 👎 0
 */
public class WiggleSubsequence376 {
    public static void main(String[] args) {
        Solution solution = new WiggleSubsequence376().new Solution();
    }
    //todo 一知半解的摆动序列
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int length = nums.length;
            if (length < 2) {
                return length;
            }
            //动态规划，要求出摆动序列的最长子序列的长度，从第一项求到第nums.length-1项；当作为递增，递减序列时的最大值
            int[] up = new int[length];
            int[] down = new int[length];
            up[0] = down[0] = 1;
            for (int i = 1; i < length; i++) {
                //对于每一个值都要和前面所有的值比较
                if (nums[i] < nums[i - 1]) {
                    //当当前值小于前一个值时
                    //对于up[i] 结尾处是递增的 而当前值小于最高处 因此0~i中的最长上摆序列依旧不会变 因为对于谷而言 i-1和i都一样(up[i-1]一致)
                    up[i] = up[i - 1];
                    //对于down[i] 因为当前值小于前一个 此处一定是一个下降的趋势 前面一定有一个峰 那么我有可能是已经在递减的路上了(和down[i-1]一致 那么这种时候down[i-1]一定是最长的) 也有可能是第一个递减的数字(从up[i-1]+1来  代表从上摆序列到下摆序列的过程)
                    down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                } else if ((nums[i] > nums[i - 1])) {
                    //当当前值大于前一个值时
                    //对于up[i] 结尾处是递增的 而当前值大于最高处因此可以从up[i-1]来，也可以从down[i-1]+1来 因为我大于前面一个值  因此前面的数组一定是一个递增的过程，那么前面第一个一定是谷而不是峰，那么我可以从前面的谷+1 从下摆转到上摆序列来
                    up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                    //对于down[i] 我大于前一个值 那么对于总体的0~i而言 我肯定去nums[i-1]位置上的值更好  因为我要的是下摆序列 结尾一定要下降的 因此还是down[i-1]
                    down[i] = down[i - 1];
                } else {
                    //相等的时候  直接和上一个一样
                    up[i] = up[i - 1];
                    down[i] = down[i - 1];
                }
            }
            return Math.max(up[length - 1], down[length - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}