package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 1052. 爱生气的书店老板
 *
 * 题目可以转换为求连续 minutes 分钟内最大的不满意顾客数 c，用原始的满意顾客数 o+c 即为结果。
 */
public class MaxSatisfied {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int o = 0, c = 0, maxC = 0;
        for (int i = 0; i < grumpy.length; i++) {
            o += grumpy[i] == 0 ? customers[i] : 0;
            c += grumpy[i] * customers[i];
            if (i < minutes - 1) {
                continue;
            }
            maxC = Math.max(maxC, c);
            c -= grumpy[i - minutes + 1] * customers[i - minutes + 1];
        }
        return o + maxC;
    }
}
