package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 3258. 统计满足 K 约束的子字符串数量 I
 *
 * 不定长滑动窗口算法-越短越合法
 *
 * 1. 入窗并统计 1 字符的数量 c。
 * 2. 当 c>k && windowSize-c>k 时窗口不满足 k 约束，缩减窗口。
 * 3. res+=right-left+1
 */
public class CountKConstraintSubstrings {
    public int countKConstraintSubstrings(String s, int k) {
        int c = 0, res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            c += s.charAt(r) - '0';
            while (c > k && r - l + 1 - c > k) {
                c -= s.charAt(l++) - '0';
            }
            res += r - l + 1;
        }
        return res;
    }
}
