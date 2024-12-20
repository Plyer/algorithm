package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 713. 乘积小于 K 的子数组
 *
 * 不定长滑动窗口算法-越短越合法
 *
 * 计算窗口元素乘积 x，如果 x>=k 那就缩减窗口，缩减完成后此窗口内以 right 结尾的所有子数组都满足要求，一共有 right-left+1 个，继续滑动窗口直至末尾。
 */
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int x = 1, res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            x *= nums[r];
            while (x >= k && l <= r) {
                x /= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}
