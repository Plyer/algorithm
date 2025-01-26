package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 948. 令牌放置
 *
 * 相向双指针：升序排序数组，左指针右移消耗能量获取分数，当能量不足时右指针左移消耗 1 分获取能量（如果右指针已经是最后一个令牌，那就不用消耗了）后继续移动左指针。
 */
public class BagOfTokensScore {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0;
        for (int l = 0, r = tokens.length - 1; l <= r; ) {
            if (power >= tokens[l]) {
                res++;
                power -= tokens[l];
                l++;
            } else {
                if (res > 0 && r > l) {
                    res--;
                    power += tokens[r--];
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
