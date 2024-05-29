import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 * <p>
 * 下述是从好到坏你可能持有的 手牌类型 ：
 * <p>
 * <p>
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * <p>
 * <p>
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 * <p>
 * 注意：返回的字符串 大小写 需与题目描述相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * 输出："Flush"
 * 解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * 输出："Three of a Kind"
 * 解释：第一、二和四张牌组成三张相同大小的扑克牌，所以得到 "Three of a Kind" 。
 * 注意我们也可以得到 "Pair" ，但是 "Three of a Kind" 是更好的手牌类型。
 * 有其他的 3 张牌也可以组成 "Three of a Kind" 手牌类型。
 * <p>
 * 示例 3：
 * <p>
 * 输入：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * 输出："Pair"
 * 解释：第一和第二张牌大小相同，所以得到 "Pair" 。
 * 我们无法得到 "Flush" 或者 "Three of a Kind" 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * ranks.length == suits.length == 5
 * 1 <= ranks[i] <= 13
 * 'a' <= suits[i] <= 'd'
 * 任意两张扑克牌不会同时有相同的大小和花色。
 * <p>
 * <p>
 * Related Topics 数组 哈希表 计数 👍 62 👎 0
 */
public class BestPokerHand2347 {
    public static void main(String[] args) {
        Solution solution = new BestPokerHand2347().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            Map<Character, Integer> map = new HashMap<>();
            for (char suit : suits) {
                map.put(suit, 1);
            }
            if (map.entrySet().size() == 1) {
                return "Flush";
            }
            /*
            这里是之前的写法，有一组单元测试没有通过，rank = [9,9,9,2,2] 答案输出应该为‘Tree of a kind’ 我这里输出了 pair
            所以还是应该把3，2的情况在遍历时分开考虑，否则确实会出现这个错误
            Map<Integer, Integer> rankMap = new HashMap<>();
            for (int rank : ranks) {
                rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : rankMap.entrySet()) {
                if (entry.getValue().equals(3) || entry.getValue().equals(4)) {
                    return "Three of a Kind";
                }
                if (entry.getValue().equals(2)) {
                    return "Pair";
                }
            }
            return "High Card";
             */

            Map<Integer, Integer> rankMap = new HashMap<>();
            for (int rank : ranks) {
                rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
            }
            //5张牌
            if (rankMap.size() == 5) {
                return "High Card";
            }
            for (Map.Entry<Integer, Integer> entry : rankMap.entrySet()) {
                if (entry.getValue() >= 3) {
                    return "Three of a Kind";
                }
            }
            return "Pair";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}