package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 1385. 两个数组间的距离值
 *
 * 双序列双指针：排序 arr2，枚举 arr1：假设 x=arr1[i]，使用二分查找在 arr2 中找到 y>=x-d 的最小值，如果 y 不存在或者 y>x+d，那么距离值加一。
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int x : arr1) {
            int mid = 0;
            for (int l = 0, r = arr2.length; l < r; ) {
                mid = l + (r - l) / 2;
                if (arr2[mid] >= x - d) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int t = 0;
            if (arr2[mid] < x - d) {
                if (mid + 1 < arr2.length) {
                    t = arr2[mid + 1];
                } else {
                    res++;
                    continue;
                }
            } else {
                t = arr2[mid];
            }

            if (t > x + d) {
                res++;
            }
        }
        return res;
    }
}
