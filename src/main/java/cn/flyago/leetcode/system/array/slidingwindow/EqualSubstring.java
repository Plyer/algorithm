package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 1208. 尽可能使字符串相等
 *
 * 不定长滑动窗口算法：在窗口中计算开销 c，当开销 c>maxCost 时缩减窗口直到 c<=maxCost，记录长度。
 */
public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int c = 0, res = 0;
        for (int r = 0, l = 0; r < s.length(); r++) {
            c += Math.abs(s.charAt(r) - t.charAt(r));
            while (c > maxCost) {
                c -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
