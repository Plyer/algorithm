package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;

/**
 * 2090 半径为 K 的子数组平均值
 *
 * 定长滑动窗口算法
 * 窗口长度定为 2k+1，求窗口元素和，当右指针位于 i 时，求出平均值赋值给 res[i-k]
 */
public class GetAverages {
    public int[] getAverages(int[] nums, int k) {
        int windowSize = 2 * k + 1;
        long sum = 0;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < windowSize - 1) {
                continue;
            }
            res[i - k] = (int) (sum / windowSize);
            sum -= nums[i - windowSize + 1];
        }
        return res;
    }
}
