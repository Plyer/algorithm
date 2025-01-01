package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 2904. 最短且字典序最小的美丽子字符串
 *
 * 不定长滑动窗口算法：在窗口中统计 1 的个数 count，当 count-(s.charAt(left)-'0')==k 时缩减窗口得出最短美丽子串，循环之后判断 count==k 则跟结果进行比较，如果长度比缓存结果小则更新结果，如果长度相同保存字典序小的串。
 */
public class ShortestBeautifulSubstring {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = s + "0";
        int count = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            count += s.charAt(r) - '0';
            while (count - (s.charAt(l) - '0') == k) {
                count -= s.charAt(l++) - '0';
            }
            if (count == k) {
                String str = s.substring(l, r + 1);
                if (str.length() < res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res.length() <= s.length() ? res : "";
    }
}
