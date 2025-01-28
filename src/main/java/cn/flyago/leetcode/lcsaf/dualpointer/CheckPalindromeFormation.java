package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 1616. 分割两个字符串得到回文串
 *
 * 相向双指针：
 * 1. 首先分别判断两个字符串是不是回文串，如果是则返回 true，如果不是则把不符合回文串的位置记录成数组。
 * 2. 定义左指针为字符串 1 的开头，右指针为字符串 2 的尾部，分别步进并判断字符是否相等，如果不相等则返回 false，如果相等则消耗对应的不符合位置数组，当其中一个消耗完成则返回 true。
 * 3. 交换指针重复第二步。
 */
public class CheckPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        int n = a.length();
        for (int l = 0, r = n - 1; l <= r; l++, r--) {
            if (a.charAt(l) != a.charAt(r)) {
                al.add(l);
            }
            if (b.charAt(l) != b.charAt(r)) {
                bl.add(l);
            }
        }
        if (al.size() == 0 || bl.size() == 0) {
            return true;
        }

        for (int l = 0, r = n - 1, j = 0, k = 0; l <= r; l++, r--) {
            if (a.charAt(l) != b.charAt(r)) {
                break;
            }
            if (l > al.get(j) && l > bl.get(k)) {
                break;
            }
            if (al.get(j) == l) {
                j++;
                if (j == al.size()) {
                    return true;
                }
            }
            if (bl.get(k) == l) {
                k++;
                if (k == bl.size()) {
                    return true;
                }
            }
        }

        for (int l = 0, r = n - 1, j = 0, k = 0; l <= r; l++, r--) {
            if (b.charAt(l) != a.charAt(r)) {
                break;
            }
            if (l > al.get(j) && l > bl.get(k)) {
                break;
            }
            if (al.get(j) == l) {
                j++;
                if (j == al.size()) {
                    return true;
                }
            }
            if (bl.get(k) == l) {
                k++;
                if (k == bl.size()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkPalindromeFormation2(String a, String b) {
        return checkPalindrom(a, b) || checkPalindrom(b, a);
    }

    public boolean checkPalindrom(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        return isPalindrome(a, l , r) || isPalindrome(b, l , r);
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }

    public static void main(String[] args) {
        new CheckPalindromeFormation().checkPalindromeFormation("cacc", "acbc");
    }
}
