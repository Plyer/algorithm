package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 1287. 有序数组中出现次数超过25%的元素
 *
 * 二分查找：次数超过25%并且是有序数组，那么元素一定经过 n/4 或者 3n/4 或者 1/2n，对这两个元素使用二分计算元素数量，大于 25% 就是结果。
 */
public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int a = n / 4;
        for (int x : new int[]{a, n / 2}) {
            if (arr[search(arr, arr[x]) + a] == arr[x]) {
                return arr[x];
            }
        }
        return arr[3 * n / 4];
    }

    private int search(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
