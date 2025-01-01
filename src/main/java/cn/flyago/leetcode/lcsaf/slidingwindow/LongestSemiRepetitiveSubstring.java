package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 2730. 找到最长的半重复子字符串
 *
 * 不定长滑动窗口算法：使用一个整数记录窗口中重复字符的末尾索引，把元素加入窗口前通过缩减窗口保证加入元素后依然符合要求，在过程中记录结果。
 */
public class LongestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        int res = 1, end = -1;
        for (int r = 1, l = 0; r < s.length(); r++) {
            char in = s.charAt(r);
            if (in == s.charAt(r - 1)) {
                if (end != -1) {
                    l = end;
                }
                end = r;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
