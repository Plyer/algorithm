package cn.flyago.leetcode.system.array.binarysearch;

/**
 * 704 二分查找
 */
public class Search {
    public int search(int[] nums, int target) {
        for (int l = 0, r = nums.length - 1; l >= 0 && r < nums.length && l <= r; ) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
