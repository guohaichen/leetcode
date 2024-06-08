import java.util.LinkedList;

/**
 * <p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>
 *
 * <pre>
 * <strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * <strong>输出：</strong>6
 * <strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>height = [4,2,0,3,2,5]
 * <strong>输出：</strong>9
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>n == height.length</code></li>
 * <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>双指针</li><li>动态规划</li><li>单调栈</li></div></div><br><div><li>👍 5183</li><li>👎 0</li></div>
 */
public class TrappingRainWater42 {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater42().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            /*
            这里使用单调递减栈来模拟一下；当遇到一个非递减的墙时，就需要弹出元素，也说明了形成了一个凹槽
            定义 wall 。因为在计算能接住雨水的容量时，需要高度和下标；
             */
            int result = 0;
            LinkedList<Wall> stack = new LinkedList<>();
            for (int i = 0; i < height.length; i++) {
                //即将入栈元素比栈顶元素大，则需要计算能接的雨水了；
                while (!stack.isEmpty() && stack.peek().height < height[i]) {
                    Wall pop = stack.pop();
                    Wall left = stack.peek();
                    //左侧没有墙，拦不住水，不用计算
                    if (left != null) {
                        int wallHeight = Math.min(left.height, height[i]) - pop.height;
                        //减去弹出栈的高度，例如 2 1 2 ，那么这个凹槽为1，面积 长*宽，- 中间节点的高度 就是能接下的雨水
                        int width = i - left.index - 1;
                        result += wallHeight * width;
                    }
                }
                stack.push(new Wall(i, height[i]));
            }
            return result;
        }
    }

    class Wall {
        //下标
        int index;
        //墙的高度
        int height;

        public Wall(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}