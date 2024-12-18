package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 *
 * 不定长滑动窗口算法：
 * 1. 因为美丽值由子序列计算得出，所以顺序无关，先对数组进行排序。
 * 2. 数组的每个元素可以看成闭区间[x-k,x+k]，当连续区间有共同交集时这部分对应元素就能变成相等元素，这样仅需判断头区间[x-k,x+k]和尾区间[y-k,y+k]有交集即可，即 x+k>=y-k，即 y-x <= 2k。
 * 3. 此时问题可转换成：排序数组后，求末尾元素减头元素小于等于 2k 的最长子数组。
 */
public class MaximumBeauty {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > 2 * k) {
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
