package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 *
 * 定长滑动窗口算法：窗口长度为 K，统计窗口中白块数量，找到最小白块数量。
 */
public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int res = Integer.MAX_VALUE, c = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if ('W' == blocks.charAt(i)) {
                c++;
            }
            if (i < k - 1) {
                continue;
            }

            res = Math.min(res, c);

            if ('W' == blocks.charAt(i - k + 1)) {
                c--;
            }
        }
        return res;
    }
}
