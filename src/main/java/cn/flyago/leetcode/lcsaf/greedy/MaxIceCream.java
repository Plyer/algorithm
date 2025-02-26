package cn.flyago.leetcode.lcsaf.greedy;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 *
 * 贪心
 */
public class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            }
            res++;
            coins -= cost;
        }
        return res;
    }

    // 计数排序
    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];
        int max = 0;
        for (int cost : costs) {
            freq[cost]++;
            max = Math.max(max, cost);
        }

        int res = 0;
        for (int i = 1; i <= max; i++) {
            if (coins < i) {
                break;
            }
            if (freq[i] == 0) {
                continue;
            }
            int c = Math.min(coins / i, freq[i]);
            res += c;
            coins -= c * i;
        }
        return res;
    }
}