package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 125. 验证回文串
 * <p>
 * 双指针：定义左指针 l=0 右指针 r=n-1，当指针所在字符不是字母数字时跳过，比较左右指针的值直到指针相遇，当左右指针的值不相等时则不是回文串。
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; ) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
