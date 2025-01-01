package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashSet;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * - 使用 Set 保存窗口长度为 K 的子串，当 Set 的长度等于 2的K次方时则包含所有
 * - 定长滑动窗口算法：把窗口中的子串转换成整数保存到 Set。
 */
public class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        int tc = (int) Math.pow(2, k);
        HashSet<String> set = new HashSet<>(tc);
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == tc) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAllCodes2(String s, int k) {
        int bit = 0;
        for (int i = 0; i < k - 1; i++) {
            bit = (bit << 1) + 1;
        }
        int tc = (int) Math.pow(2, k);
        int num = 0;
        HashSet<Integer> set = new HashSet<>(tc);
        for (int i = 0; i < s.length(); i++) {
            num = (num << 1) + Character.digit(s.charAt(i), 2);
            if (i < k - 1) {
                continue;
            }
            set.add(num);
            if (set.size() == tc) {
                return true;
            }
            num &= bit;
        }
        return false;
    }
}
