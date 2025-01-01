package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 209. 长度最小的子数组
 *
 * 不定长滑动窗口算法，有两种方案：
 * 1. 窗口中求和 sum，当 sum>=target 时缩减窗口，在缩减过程中保存结果。
 * 2. 窗口中求和 sum，当 sum-nums[left]>=target 时缩减窗口（相当于在循环条件中做一次循环体的操作，判断一次循环之后是否还满足要求，这样循环结束得到的就是满足要求的最值），这样缩减完成之后就是满足 sum>=target 的最小窗口，此时如果 sum>=target 则记录结果（因为窗口很小时并未经过缩减不满足 sum>=target）。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = n + 1, sum = 0;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        return res <= n ? res : 0;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int n = nums.length, res = n + 1, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum - nums[l] >= target) {
                sum -= nums[l++];
            }
            if (sum >= target) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res <= n ? res : 0;
    }
}
