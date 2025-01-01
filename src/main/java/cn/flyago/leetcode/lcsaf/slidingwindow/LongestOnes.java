package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 1004. 最大连续1的个数 III
 *
 * 不定长滑动窗口算法：问题可以转换成求数组元素中至多有 K 个0的最长子串长度。
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int res = 0, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (r - l + 1 - sum > k) {
                sum -= nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
