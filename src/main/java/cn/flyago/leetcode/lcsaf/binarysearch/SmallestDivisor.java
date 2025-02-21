package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 1283. 使结果不超过阈值的最小除数
 *
 * 二分查找：根据提示 nums.length <= threshold 可得除数的范围是 [1,max(nums)]，使用二分查找出满足条件的最小除数。
 */
public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, threshold)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int m, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num - 1) / m + 1;
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}
