package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 704. 二分查找
 */
public class Search {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (l == nums.length || nums[l] != target) {
            return -1;
        }
        return l;
    }
}
