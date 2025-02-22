package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 875. 爱吃香蕉的珂珂
 *
 * 二分查找：吃香蕉速度越大，花费时间越少，满足单调性，可以使用二分算法。
 * 1. 速度范围 [1,10^9]
 * 2. check 函数：枚举 piles，对 (piles[i]-1)/m + 1 求和，如果和大于 h 则就吃不完。
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 1000000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l > 1000000000 ? -1 : l;
    }

    private boolean check(int[] piles, int m, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile - 1) / m + 1;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }
}
