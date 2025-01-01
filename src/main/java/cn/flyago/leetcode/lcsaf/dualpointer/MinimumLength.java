package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 1750. 删除字符串两端相同字符后的最短长度
 *
 * 相向双指针：定义 l=0 r=n-1，当 l<r && arr[l]==arr[r] 时进入循环：左指针右移直到遇到不相等的字符，如果 l==r return 0，右指针左移直到遇到不相等的字符。结果是 r-l+1。
 */
public class MinimumLength {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            for (l++; l < r && s.charAt(l) == s.charAt(l - 1); l++) {}
            for (r--; l < r && s.charAt(r) == s.charAt(r + 1); r--) {}
        }
        return r - l + 1;
    }

    public int minimumLength2(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char c = s.charAt(l);
            while (l <= r && s.charAt(l) == c) l++;
            while (l <= r && s.charAt(r) == c) r--;
        }
        return r - l + 1;
    }
}
