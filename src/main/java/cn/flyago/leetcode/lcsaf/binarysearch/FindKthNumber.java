package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 668. 乘法表中第k小的数
 *
 * 二分查找：第 k 小的问题可以转化成 <=x 的值至少有 k 个。
 * 1. 数的范围 [1,m*n]，优化一下：把上界改为 m*n-1，这样最后返回的 l 即使越界也是 m*n，也是合法答案。
 * 2. check 函数：枚举 m，每一行小于等于 x 的值的数量是 min(x/i,n)，求和。循环结束后的和就是整个乘法表 <=x 的数量。
 */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(m, n, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int m, int n, int k, int mid) {
        int sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += Math.min(n, mid / i);
            if (sum >= k) {
                return true;
            }
        }
        return false;
    }
}
