package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 2563. 统计公平数对的数目
 *
 * 二分查找：重点是理解对数组进行排序不影响结果。
 */
public class CountFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            res += search(nums, i + 1, n, upper - nums[i] + 1) - search(nums, i + 1, n, lower - nums[i]);
        }
        return res;
    }

    private int search(int[] arr, int l, int r, int t) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
