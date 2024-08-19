/**
 * <p>给你一个长度为 <code>n</code> 的字符串 <code>moves</code> ，该字符串仅由字符 <code>'L'</code>、<code>'R'</code> 和 <code>'_'</code> 组成。字符串表示你在一条原点为 <code>0</code> 的数轴上的若干次移动。</p>
 *
 * <p>你的初始位置就在原点（<code>0</code>），第 <code>i</code> 次移动过程中，你可以根据对应字符选择移动方向：</p>
 *
 * <ul>
 * <li>如果 <code>moves[i] = 'L'</code> 或 <code>moves[i] = '_'</code> ，可以选择向左移动一个单位距离</li>
 * <li>如果 <code>moves[i] = 'R'</code> 或 <code>moves[i] = '_'</code> ，可以选择向右移动一个单位距离</li>
 * </ul>
 *
 * <p>移动 <code>n</code> 次之后，请你找出可以到达的距离原点 <strong>最远</strong> 的点，并返回 <strong>从原点到这一点的距离</strong> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>moves = "L_RL__R"
 * <strong>输出：</strong>3
 * <strong>解释：</strong>可以到达的距离原点 0 最远的点是 -3 ，移动的序列为 "LLRLLLR" 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>moves = "_R__LL_"
 * <strong>输出：</strong>5
 * <strong>解释：</strong>可以到达的距离原点 0 最远的点是 -5 ，移动的序列为 "LRLLLLL" 。
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>moves = "_______"
 * <strong>输出：</strong>7
 * <strong>解释：</strong>可以到达的距离原点 0 最远的点是 7 ，移动的序列为 "RRRRRRR" 。
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= moves.length == n &lt;= 50</code></li>
 * <li><code>moves</code> 仅由字符 <code>'L'</code>、<code>'R'</code> 和 <code>'_'</code> 组成</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>字符串</li><li>计数</li></div></div><br><div><li>👍 10</li><li>👎 0</li></div>
 */
public class FurthestPointFromOrigin2833 {
    public static void main(String[] args) {
        Solution solution = new FurthestPointFromOrigin2833().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int left = 0;
            int right = 0;
            int middle = 0;
            for (char c : moves.toCharArray()) {
                if (c == 'L') {
                    left++;
                } else if (c == 'R') {
                    right++;
                } else {
                    middle++;
                }
            }
            if (left > right) {
                return left - right + middle;
            } else {
                return right - left + middle;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}