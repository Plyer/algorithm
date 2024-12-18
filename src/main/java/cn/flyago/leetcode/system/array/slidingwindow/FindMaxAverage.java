package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 643 子数组最大平均数 Ⅰ
 *
 * 定长滑动窗口算法
 * 1. 入窗口求和，直到窗口符合长度
 * 2. 更新结果
 * 3. 出窗口重新计算和。
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 入窗口求和
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            // 更新结果
            res = Math.max(res, sum / k);
            // 出窗口
            sum -= nums[i - k + 1];
        }
        return res;
    }
}
