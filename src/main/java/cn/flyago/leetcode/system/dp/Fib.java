package cn.flyago.leetcode.system.dp;

/**
 * 509 斐波那契数
 * 初始化一个长度为n+1的数组dp，dp[1]=1，从索引为2的位置遍历计算斐波那契数直到索引为n找到结果。
 */
public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
