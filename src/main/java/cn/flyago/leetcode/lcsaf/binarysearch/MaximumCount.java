package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 2529. 正整数和负整数的最大计数
 *
 * 二分查找：问题可以转换成求大于零的最小索引 a 和小于零的最大索引 b，结果是 Math.max(b+1, n-a)。
 */
public class MaximumCount {
    public int maximumCount(int[] nums) {
        int a = search(nums, 1);
        int b = search(nums, 0) - 1;
        return Math.max(b + 1, nums.length - a);
    }

    private int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
