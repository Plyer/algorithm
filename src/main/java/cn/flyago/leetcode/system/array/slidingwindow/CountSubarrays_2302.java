package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 2302. 统计得分小于 K 的子数组数目
 *
 * 不定长滑动窗口算法-越短越合法：
 * 1. 入窗并计算窗口内子数组和 sum。
 * 2. 如果 sum * windowSize >= k，缩减窗口：sum -= arr[left]。
 * 3. 更新结果，res+=windowSize。
 */
public class CountSubarrays_2302 {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}
