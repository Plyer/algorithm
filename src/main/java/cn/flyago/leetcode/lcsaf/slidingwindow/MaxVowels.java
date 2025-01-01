package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 1456 定长字串中元音的最大数目
 *
 * 定长滑动窗口算法
 * 1. 入窗口并计算元音数，直到窗口长度符合要求
 * 2. 更新结果
 * 3. 出窗口：i-k+1 的元素出窗口，计算元音数
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        int res = 0, x = 0;
        for (int i = 0; i < s.length(); i++) {
            // 入窗口
            char in = s.charAt(i);
            if (in == 'a' || in == 'e' || in == 'i' || in == 'o' || in == 'u') {
                x++;
            }
            if (i < k - 1) {
                continue;
            }
            // 更新结果
            res = Math.max(res, x);
            // 出窗口
            char out = s.charAt(i - k + 1);
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                x--;
            }
        }
        return res;
    }
}
