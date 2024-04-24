import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 10095 👎 0
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters3().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //思路：要计算
            //用来检查是否包含重复子串，key为字符，value为下标，在遍历字符串时，
            // 如果key重复，那么根据key就能找到该重复元素的下标，下标则重该下标+1开始
            HashMap<Character, Integer> map = new HashMap<>();
            int begin = 0;
            int maxLength = 0;
            for (int end = 0; end < s.length(); end++) {
                //重复
                if (map.containsKey(s.charAt(end))) {
                    //重复的话,调整开始位置，开始位置为map的value，不包含该value，则+1
                    //abba 像假设现在遍历最后一个a时，begin 从map中获取的话，会为 0，所以需要从begin 和 获取到的取最大值
                    begin = Math.max(begin, map.get(s.charAt(end)) + 1);
                    map.put(s.charAt(end), end);
                } else {
                    map.put(s.charAt(end), end);
                }
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}