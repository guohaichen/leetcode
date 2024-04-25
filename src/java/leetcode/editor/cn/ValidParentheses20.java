import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 4431 👎 0
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses20().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
                /*思路：只要是有效的字符串，则他们的括号则是匹配的，有一个左括号，则必须要有一个右括号，且顺序一致
                遍历时，将对应括号存入栈中，如果不是左括号，则将与栈中元素对比，注意 peek 和 pop
                注意结束条件，栈是否为空，为空则代表括号刚好匹配，*/
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{') {
                    stack.push('}');
                } else if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else {
                    // !stack.isEmpty() 这里是因为如果测试用例以‘]’右括号开始的话，则出栈的则为null，null与字符作比较，爆出空指针异常
                    if (!stack.isEmpty() && c == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}