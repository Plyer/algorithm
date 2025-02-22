package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * 二分查找：随着船的运载能力增加，运输天数会减少，符合单调性，可以使用二分算法。
 * 1. 确定运载能力的范围 [max(weights), 25*10^6]。优化：最高运力是 sum(weights)。
 * 2. 实现 check 函数，枚举 weights：求和，如果当前满载则天数加一并继续下一次，如果当前是最后一个包裹，天数加一并结束，否则判断当前和加上下一个包裹是否会超载，如果超载那么当前运输次数加一并且把和重置。
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int l = max, r = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(weights, mid, days)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l > sum ? -1 : l;
    }

    private boolean check(int[] weights, int m, int days) {
        int sum = 0;
        int n = weights.length, useDays = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum == m || (i + 1 < n && sum + weights[i + 1] > m)) {
                useDays++;
                sum = 0;
                continue;
            }
            if (i == n - 1) {
                useDays++;
            }
        }
        return useDays <= days;
    }
}
