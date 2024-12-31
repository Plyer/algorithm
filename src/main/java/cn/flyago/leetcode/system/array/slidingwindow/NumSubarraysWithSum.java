package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 930. 和相同的二元子数组
 *
 * 不定长滑动窗口算法-恰好型，可转换成两种解法：
 * 1. 至多 k 和至多 k-1，两次滑窗结果 f(k)-f(k-1) 即为恰好 k 的子数组数量。
 * 2. 至少 k 和至少 k+1，两次滑窗结果 f(k)-f(k+1) 即为恰好 k 的子数组数量。
 *
 * 滑窗：
 * 1. 入窗求和 sum，当 sum > x 时 缩减窗口，更新结果 res+=right-left+1。
 * 2. 入窗求和 sum，当 sum >= x 时缩减窗口，更新结果 res+=left。
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums, goal) - slidingWindow(nums, goal + 1);
    }

    private int slidingWindow(int[] nums, int x) {
        int sum = 0, res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= x && l <= r) {
                sum -= nums[l++];
            }
            res += l;
        }
        return res;
    }
}
