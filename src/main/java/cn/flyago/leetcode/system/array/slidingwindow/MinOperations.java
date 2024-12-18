package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 *
 * 不定长滑动窗口算法：先求数组的元素和 sum。问题可以转换成和为 sum-x 的最大子数组长度。
 */
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if (sum == x) {
            return nums.length;
        } else if (sum < x) {
            return -1;
        }
        int max = 0, csum = 0, t = sum - x;
        for (int l = 0, r = 0; r < nums.length; r++) {
            csum += nums[r];
            while (csum > t) {
                csum -= nums[l++];
            }
            if (csum == t) {
                max = Math.max(max, r - l + 1);
            }
        }

        if (max == 0) {
            return -1;
        }
        return nums.length - max;
    }
}
