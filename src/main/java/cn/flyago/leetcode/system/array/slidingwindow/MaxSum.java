package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. 几乎唯一子数组的最大和
 *
 * 定长滑动窗口算法：在窗口内记录元素和以及元素的数量，在不重复元素数量满足题意时更新结果。
 */
public class MaxSum {
    public long maxSum(List<Integer> nums, int m, int k) {
        long sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            sum += num;
            map.merge(num, 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (map.size() >= m) {
                res = Math.max(res, sum);
            }

            Integer out = nums.get(i - k + 1);
            sum -= out;
            if (map.merge(out, -1, Integer::sum) == 0) {
                map.remove(out);
            }
        }
        return res;
    }
}
