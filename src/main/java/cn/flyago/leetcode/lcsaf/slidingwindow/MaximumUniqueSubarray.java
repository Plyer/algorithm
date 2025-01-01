package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 *
 * 不定长滑动窗口算法：使用 set 记录窗口非重复元素，在把元素加入窗口前通过缩减窗口保证加入后满足题意，滑动过程中记录子数组的和。
 */
public class MaximumUniqueSubarray {
    public int maximumUniqueSubarray(int[] nums) {
        int res = 0, sum = 0;
        Set<Integer> set = new HashSet<>(Math.min(nums.length, 10000));
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            res = Math.max(res, sum);
        }
        return res;
    }
}
