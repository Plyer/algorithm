package cn.flyago.leetcode.system.array.binarysearch;

/**
 * 34 在排序数组中查找元素的第一个和最后一个位置
 * 二分查找法：在找到 target 之后使用两个循环分别往左和往右寻找边界。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left >= 0 && right < nums.length && left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int l = mid - 1, r = mid + 1;
                for (; l >= 0 && nums[l] == target; l--) {}
                for (; r < nums.length && nums[r] == target; r++);
                return new int[]{l + 1, r - 1};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
