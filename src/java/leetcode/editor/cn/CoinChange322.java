//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2820 👎 0

import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        Solution solution = new CoinChange322().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange322().coinChange2(new int[]{1, 2, 5}, 11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {

            int[] dp = new int[amount + 1];

            Arrays.fill(dp, amount + 1);
            //凑0 最少就是0个硬币
            dp[0] = 0;
            //背包容量
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    //装得下，判断哪种方法数量更少，i-coin为背包剩余容量能装下物品的最小组合，+1 因为当前物品也装下了
                    // dp[i - coin] != amount + 1 排除剩余容量 装不下的情况
                    if (i >= coin && dp[i - coin] != amount + 1) {
                        dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 降维化简
     *
     * @param coins  硬币/物品重量
     * @param amount 钱币量/背包总量
     * @return 最少的硬币数
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                //装得下
                if (j >= coin) {
                    dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public int coinChange3(int[] coins, int amount) {
            /*完全背包问题，每种硬币的数量是无限的 dp[硬币数量][背包重量]，dp[i][j]= 物品的价值，而这里求的是 最少的硬币个数;
            这里可以将物品的价值统一为1，那么它也就是物品的个数，装得下：min(当前个数+1)
             */
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];

        for (int j = 1; j <= amount; j++) {
            int coin0 = coins[0];
            if (coin0 <= j) {
                dp[0][j] = (dp[0][j - coin0] + 1);
            } else {
                //特殊，凑不到的总额 因为存放的是硬币的个数，不可能超过amount+1，总额是amount
                dp[0][j] = amount + 1;
            }
        }


        for (int i = 1; i < coins.length; i++) {
            int coin = coins[i];
            //总量
            for (int j = 1; j <= amount; j++) {
                //装得下，硬币数量+1
                if (coin <= j) {
                    //上次的硬币少 还是这次的硬币少
                    dp[i][j] = Integer.min(dp[i - 1][j], 1 + dp[i][j - coin]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int max = dp[coins.length - 1][amount];
        return (max > amount) ? -1 : dp[coins.length - 1][amount];
    }
}