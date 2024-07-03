//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1297 👎 0

public class CoinChangeIi518 {
    public static void main(String[] args) {
        Solution solution = new CoinChangeIi518().new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //返回可以凑成总金额的硬币组合数；存入背包的也就是组合数,上一轮的组合数 + 本轮剩余 背包容量的 组合数
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            /*
             凑成0元总有一种方法，那就是不使用任何硬币
             这个初始化对于后续的动态规划状态转移至关重要。在计算更高金额（如dp[1], dp[2], ... 直至 dp[amount]）的组合数时，会用到dp[0]的值。
             例如，当我们考虑如何用硬币凑成金额i时，如果某硬币的面额正好是i，那么除了直接使用这一个硬币外，之前累计到dp[i-coin]的所有组合（即不使用这个硬币时凑成i-coin的方法数）现在也都可以通过再加上这一个硬币来构成一个新的组合，从而凑成i。
             而这个累积过程正是从dp[0] = 1开始的，它确保了即使没有任何额外的硬币被选择时，也会计为一种有效的组合方式。
             */

            /*
            二刷新的体会：
             * 题干说的是每一种面额的硬币有无限个，则是一个完全背包；
             * 定义一个数组dp[],长度为amount+1 代表背包的容量;
             * 外循环遍历整个硬币面额，内循环遍历背包重量，如果背包重量大于等于硬币面额，
             * 那么当前背包重量的组合 dp[i] = dp[i] + dp[i-coin] ，右边的dp[i]为当前背包总量上次硬币所装下的组合数，dp[i-coin]为剩余重量能装下的组合数
             */

            dp[0] = 1;
            for (int coin : coins) {
                //可以化简为 j = coin
                for (int j = 1; j <= amount; j++) {
                    //装得下
                    if (j >= coin) {
                        dp[j] = dp[j] + dp[j - coin];
                    }
                }
            }
            return dp[amount];
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}