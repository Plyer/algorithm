package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 275. H 指数 II
 *
 * 二分查找：当指数变大时，数组中大于等于指数的论文数量就会变少，使符合要求的指数数量变少，更接近最大指数，符合单调性。
 * 1. 指数范围 [0,n]，由于 h=0 一定满足，所以范围可以改成 [1,n]，当在二分范围没找到答案时，答案就是 0。
 * 2. check 函数：citations[n-mid]>=mid，citations[n-mid]就是数组中第 mid 大的值，此时数量符合指数要求，当这个值大于等于指数时这个指数就完全符合要求。
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[n - mid] >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // r 越界时值为 0，刚好是二分范围未包括的肯定合法的指数，所以不再需要越界判断。
        return r;
    }

//    private boolean check(int[] citations, int m) {
//        int l = 0, r = citations.length - 1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (citations[mid] >= m) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return citations.length - l >= m;
//    }
}
