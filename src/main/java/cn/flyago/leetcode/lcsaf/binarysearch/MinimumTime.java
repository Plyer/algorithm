package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 2187. 完成旅途的最少时间
 *
 * 二分查找：随着时间增加，完成的旅途数量也增加，满足单调性，可以使用二分算法。
 * 1. 根据提示，当 totalTrips 是最大值 10^7，且 time 数组仅有一辆车，车辆耗时 10^7，此时消耗时间最大为 10^14，所以时间范围是 [1,10^14]，在这个范围执行二分查找。
 * 2. 实现 check 函数，枚举 time 数组求每辆车完成的旅途数量，求和，跟 totalTrips 比较。
 */
public class MinimumTime {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1, r = 10000000L * 10000000;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (check(time, mid, totalTrips)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] time, long m, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += m / t;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
