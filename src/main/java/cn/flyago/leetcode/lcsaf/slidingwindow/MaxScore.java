package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.Arrays;

/**
 * 1423. 可获得的最大点数
 *
 * 定长滑动窗口算法：题目可转换为求长度为 len-k 的子数组和最小值，注意 len=k 的情况。
 */
public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == k) {
            return Arrays.stream(cardPoints).sum();
        }
        int minSum = Integer.MAX_VALUE, sum = 0, arrSum = 0, windowSize = cardPoints.length - k;
        for (int i = 0; i < cardPoints.length; i++) {
            arrSum += cardPoints[i];
            sum += cardPoints[i];
            if (i < windowSize - 1) {
                continue;
            }
            minSum = Math.min(minSum, sum);
            sum -= cardPoints[i - windowSize + 1];
        }
        return arrSum - minSum;
    }
}
