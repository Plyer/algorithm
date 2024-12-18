package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2799. 统计完全子数组的数目
 *
 * 不定长滑动窗口算法-越长越合法：首先遍历数组获取不同元素的数量 count，然后执行滑动窗口算法：使用 map 记录元素的数量，当 map.size==count 时缩减窗口，缩减完成后记录结果。
 */
public class CountCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        int count = (int) Arrays.stream(nums).distinct().count();
        Map<Integer, Integer> map = new HashMap<>(count);
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            map.merge(nums[r], 1, Integer::sum);
            while (map.size() == count) {
                if (map.merge(nums[l], -1, Integer::sum) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            res += l;
        }
        return res;
    }
}
