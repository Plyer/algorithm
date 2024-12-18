package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 *
 * 不定长滑动窗口算法：使用 map 记录窗口元素数量，当元素数量大于 K 时缩减窗口，滑动过程中记录最大子数组长度。
 */
public class MaxSubarrayLength {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int l = 0, r = 0; r < nums.length; r++) {
            int in = nums[r];
            map.merge(in, 1, Integer::sum);
            while (map.get(in) > k) {
                int left = nums[l];
                map.merge(left, -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
