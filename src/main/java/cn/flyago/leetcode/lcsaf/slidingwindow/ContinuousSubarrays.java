package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2762. 不间断子数组
 *
 * 不定长滑动窗口算法-越短越合法
 * 1. 入窗并记录子数组最大值 max、最小值 min、数组元素的个数 map。
 * 2. 当 max-min>2 时缩减窗口：更新 map, max, min。
 * 3. 更新结果 res+=right-left+1
 */
public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int l = 0, r = 0; r < nums.length; r++) {
            map.merge(nums[r], 1, Integer::sum);
            while (map.lastKey() - map.firstKey() > 2) {
                if (map.merge(nums[l], -1, Integer::sum) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }

}
