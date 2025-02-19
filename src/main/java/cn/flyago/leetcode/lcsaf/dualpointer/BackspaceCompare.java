package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 844. 比较含退格的字符串
 *
 * 双序列双指针：
 * 1. 在两个字符串的末尾定义指针 i j，两个指针一边比较一边向左移动，当指针值不是退格字符且相等时继续移动，当指针值都不是退格字符且不相等则无法转化，当指针值遇到退格字符则向左移动记录退格数并删除对应数目的字符。
 * 2. 如果其中一个字符串还有剩余，剩下的字符串必须全部被退格。
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length(), m = t.length();
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j) && s.charAt(i) != '#') {
                i--;
                j--;
                continue;
            }
            if (s.charAt(i) != t.charAt(j) && s.charAt(i) != '#' && t.charAt(j) != '#') {
                return false;
            }

            if (s.charAt(i) == '#') {
                i = delete(s, i);
            }

            if (t.charAt(j) == '#') {
                j = delete(t, j);
            }
        }

        if ((i >= 0 && s.charAt(i) != '#') || (j >= 0 && t.charAt(j) != '#')) {
            return false;
        }

        if (c(s, i) > 0 || c(t, j) > 0) {
            return false;
        }
        return true;
    }

    private int delete(String s, int i) {
        int c = 1;
        for (i--; i >= 0 && c > 0; i--) {
            if (s.charAt(i) != '#') {
                c--;
            } else {
                c++;
            }
        }
        return i;
    }

    private int c(String s, int i) {
        int k = 0;
        while (k <= i && s.charAt(k) == '#') {
            k++;
        }
        int c = 0;
        for (; k <= i; k++) {
            if (s.charAt(k) != '#') {
                c++;
            } else {
                c--;
            }
        }
        return c;
    }
}
