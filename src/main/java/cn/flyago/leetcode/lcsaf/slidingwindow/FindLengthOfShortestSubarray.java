package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 *
 * 不定长滑动窗口算法：
 * 1. 数组从尾部往头部遍历找非递增边界，边界及之后的数组就是尾部的非递减数组，假设需要删除的子数组为(l,r)不包括边界，r的范围就是前面计算的尾部非递减数组直至 n+1（这种情况就是删除的数组位于尾部）。
 * 2. 枚举 r，当 arr[l]<=arr[r] && (l == 0 || arr[l-1]<=arr[l]) 删除数组(l,r)后剩余数组有序，此时循环缩减窗口并更新结果。
 */
public class FindLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int r = n - 1;
        for (; r > 0 && arr[r - 1] <= arr[r]; r--) {}
        if (r == 0) {
            return 0;
        }

        int res = r;
        for (int l = 0; r <= n; r++) {
            while ((r == n || arr[l] <= arr[r]) && (l == 0 || arr[l - 1] <= arr[l])) {
                res = Math.min(res, r - l - 1);
                l++;
            }
        }

        return res;
    }
}
