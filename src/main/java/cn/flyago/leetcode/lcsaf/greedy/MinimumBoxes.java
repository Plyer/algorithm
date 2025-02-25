package cn.flyago.leetcode.lcsaf.greedy;

import java.util.Arrays;

/**
 * 3074. 重新分装苹果
 *
 * 贪心：排序箱子，枚举苹果从最大的箱子开始装。
 */
public class MinimumBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int n = capacity.length, j = n - 1, sum = 0;
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
            while (sum > capacity[j]) {
                sum -= capacity[j--];
            }
        }

        return n - j;
    }
}
