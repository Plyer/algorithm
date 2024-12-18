package cn.flyago.leetcode.system.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        return coinChange(coins, amount, dp);
    }

    int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        } else if (dp[amount] != -2) {
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int t = coinChange(coins, amount - coin, dp) + 1;
            if (t > 0) {
                res = Math.min(res, t);
            }
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        dp[amount] = res;
        return res;
    }
}
