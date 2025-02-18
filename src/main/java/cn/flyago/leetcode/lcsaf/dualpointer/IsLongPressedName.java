package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 925. 长按键入
 *
 * 双序列双指针：
 * 1. i=0 j=0，枚举 name：当两个指针所在字符不同时，如果 typed[j]==typed[j-1]，typed 移动指针到跟当前字符不同的字符再跟 name[i] 进行对比，如果不同则 false，否则继续枚举。
 * 2. 最后，如果 j<type.len，枚举 j 直到末尾，所有字符必须等于 typed[j-1]。
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for (int i = 0; i < name.length(); i++, j++) {
            if (j == typed.length()) {
                return false;
            }
            if (name.charAt(i) != typed.charAt(j)) {
                while (j > 0 && j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                }
                if (j == 0 || j == typed.length() || typed.charAt(j) != name.charAt(i)) {
                    return false;
                }
            }
        }

        while (j < typed.length()) {
            if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        return true;
    }
}
