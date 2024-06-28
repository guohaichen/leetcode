import java.util.ArrayList;
import java.util.List;

/**
 * <p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>
 *
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>
 *
 * <p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png" style="width: 200px;" /></p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>digits = "23"
 * <strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>digits = ""
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>digits = "2"
 * <strong>输出：</strong>["a","b","c"]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= digits.length &lt;= 4</code></li>
 * <li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 2843</li><li>👎 0</li></div>
 */
public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber17().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.isEmpty()) {
                return result;
            }

            //对应0-9
            String[] numMap = new String[]{
                    "",
                    "",
                    "abc",
                    "def",
                    "ghi",
                    "jkl",
                    "mno",
                    "pqrs",
                    "tuv",
                    "wxyz"
            };
            //for循环第一次有效
            result.add("");
            for (char c : digits.toCharArray()) {
                //char只能位 2-9 所以可以这样转int
                int index = c - '0';
                List<String> ans = new ArrayList<>();
                for (String res : result) {
                    for (char letter : numMap[index].toCharArray()) {
                        ans.add(res + letter);
                    }
                }
                result = ans;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}