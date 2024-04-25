import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有
 * "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 625 👎 0
 */
public class RemoveAllAdjacentDuplicatesInString1047 {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString1047().new Solution();
        solution.removeDuplicates("abbaca");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            String result = "";
            //注意最后返回的时候按照顺序， 因为存入栈 是先入后出，所以出栈时候从左往右拼接；
            while (!stack.isEmpty()) {
                //c - > a
                //c a
                result = stack.pop() + result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}