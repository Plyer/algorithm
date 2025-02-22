package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 1870. 准时到达的列车最小时速
 *
 * 二分查找：列车时速越大，所花费的总时间越短，满足单调性，可以使用二分算法。
 * 1. 首先确定时速范围 [1, 10^7]。
 * 2. 实现 check 函数，枚举 dist 求当前时速 dist[i]/mid 的上界即 dist[i]-1/mid 的下界加一，对上界求和并跟 hour 比较，注意最后一辆车不需要求上界。
 */
public class MinSpeedOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n - 1 > hour) {
            return -1;
        }
        int max = 200000 - 1;
        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(dist, mid, hour)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l > max ? -1 : l;
    }

    private boolean check(int[] dist, int m, double hour) {
        int sum = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            sum += (dist[i] - 1) / m + 1;
            if (sum > hour) {
                return false;
            }
        }
        return sum + dist[dist.length - 1] / (double) m > hour;
    }
}
