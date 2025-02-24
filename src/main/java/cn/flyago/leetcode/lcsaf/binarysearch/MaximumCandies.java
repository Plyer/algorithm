package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 2226. 每个小孩最多能分到多少糖果
 *
 * 二分答案：每个小孩分到的糖果越多，总糖果数可分成的堆数越少，符合单调性，可以使用二分算法。
 * 1. 每个小孩分到的糖果数范围 [0,10^7]。优化下界为 1，当返回 r 越界时为 0 符合分不到糖果的情况。
 * 2. check 函数：枚举 candies，当前糖果堆可分成 candies[i]/m 个子堆，求子堆数量和，如果总和大于等于小孩个数，那这个糖果数就符合。
 */
public class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int l = 1, r = 10000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(candies, k, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }

    private boolean check(int[] candies, long k, int mid) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy / mid;
            if (sum >= k) {
                return true;
            }
        }
        return false;
    }
}
