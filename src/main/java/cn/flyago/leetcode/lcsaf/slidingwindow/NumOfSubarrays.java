package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 *
 * 定长滑动窗口
 * 1. 入窗口求和，直到窗口长度符合要求
 * 2. 求平均值更新结果
 * 3. 出窗口求和
 */
public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1) {
                continue;
            }
            if (sum / (double) k >= threshold) {
                res++;
            }
            sum -= arr[i - k + 1];
        }
        return res;
    }
}
