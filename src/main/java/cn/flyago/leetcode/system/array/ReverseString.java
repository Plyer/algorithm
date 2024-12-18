package cn.flyago.leetcode.system.array;

/**
 * 344 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
