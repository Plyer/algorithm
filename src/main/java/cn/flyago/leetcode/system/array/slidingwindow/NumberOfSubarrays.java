package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 1248. 统计「优美子数组」
 *
 * 不定长滑动窗口算法-恰好型：至多解法，越短越合法，res=f(k)-f(k-1)。
 * 1. 入窗保存子数组的奇数个数 c（c += nums[i] & 1）。
 * 2. 当 c > k 时缩减窗口，c -= nums[i] & 1。
 * 3. 更新结果 ans += right - left + 1
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }

    private int f(int[] nums, int x) {
        int c = 0, ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            c += nums[r] & 1;
            while (c > x) {
                c -= nums[l++] & 1;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
