package cn.flyago.leetcode.lcsaf.slidingwindow;

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

    // 求非空子数组和大于等于 t 的子数组数量
    // 子数组和至少 >=k 的滑窗：当窗口内的和 >=k 时，左指针不变，当前右指针直到数组末尾的子数组的和都 >=k，所以 res+=n-r，循环缩减窗口直到子数组和 <=k，循环过程中的结果都要记录，继续枚举直到右指针达到末尾。
    private int slidingWindo2(int[] nums, int t) {
        int res = 0, sum = 0;
        int n = nums.length;
        for (int l = 0, r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= t && l <= r) {
                res += n - r;
                sum -= nums[l++];
            }
        }
        return res;
    }
}
