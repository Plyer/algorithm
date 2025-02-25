package cn.flyago.leetcode.lcsaf.greedy;

import java.util.Arrays;

/**
 * 2279. 装满石头的背包的最大数量
 *
 * 贪心：计算背包剩余容量按升序排序，枚举剩余容量直到把额外石头装完或者背包全部装满。
 */
public class MaximumBags {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(capacity);
        int sum = 0;
        for (int i = 0; i < capacity.length; i++) {
            sum += capacity[i];
            if (sum == additionalRocks) {
                return ++i;
            } else if (sum > additionalRocks) {
                return i;
            }
        }
        return capacity.length;
    }

    public int maximumBags2(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(capacity);
        int res = 0;
        for (int c : capacity) {
            if (c > additionalRocks) {
                break;
            }
            res++;
            additionalRocks -= c;
        }
        return res;
    }
}
