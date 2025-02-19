package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 二分查找：先求 >=x 的最小元素 min，如果 min==x 此元素为第一个位置，那么最后一个位置即为 <=x 的最大元素。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int s = lowerBone(nums, target);
        if (s < 0 || s >= nums.length || nums[s] != target) {
            return new int[]{-1, -1};
        }
        int e = lowerBone(nums, target + 1) - 1;
        return new int[]{s, e};
    }

    private int lowerBone(int[] arr, int t) {
        int l = 0, r = arr.length - 1;
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
