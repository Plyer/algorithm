package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 35. 搜索插入位置
 *
 * 二分查找：题目可以转换为求 >=target 的最小位置。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
