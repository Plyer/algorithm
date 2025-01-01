package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2461. 长度为 K 子数组中的最大和
 *
 * 定长滑动窗口算法：记录窗口元素和并用Map记录元素数量，记录结果。
 */
public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            map.merge(num, 1, Integer::sum);
            if (i < k - 1) {
                continue;
            }
            if (map.size() == k) {
                res = Math.max(res, sum);
            }
            int out = nums[i - k + 1];
            sum -= out;
            if (map.merge(out, -1, Integer::sum) == 0) {
                map.remove(out);
            }
        }
        return res;
    }
}
