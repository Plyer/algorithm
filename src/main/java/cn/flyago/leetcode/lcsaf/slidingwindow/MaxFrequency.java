package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 * <p>
 * 不定长滑动窗口算法：降序排序数组，以窗口第一个数 left 作为基准，记录窗口元素和 sum，当 left*windowSize-sum<=k 时窗口符合条件，记录窗口长度。
 */
public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, res = 0;
        for (int l = nums.length - 1, r = l; l >= 0; l--) {
            sum += nums[l];
            int windowSize = r - l + 1;
            while (nums[r] * windowSize - sum > k) {
                sum -= nums[r--];
                windowSize = r - l + 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
