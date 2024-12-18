package cn.flyago.leetcode.system.array;

/**
 * 5 最长回文字串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int left = -1, right = -2;
        for (int i = 0; i < s.length(); i++) {
            int[] ints = help(s, i, i);
            if (ints[1] - ints[0] > right - left) {
                left = ints[0];
                right = ints[1];
            }
            if (i + 1 < s.length()) {
                ints = help(s, i, i + 1);
                if (ints[1] - ints[0] > right - left) {
                    left = ints[0];
                    right = ints[1];
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public int[] help(String s, int left, int right) {
        for (; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); left--, right++) {}
        return new int[]{left + 1, right - 1};
    }
}
