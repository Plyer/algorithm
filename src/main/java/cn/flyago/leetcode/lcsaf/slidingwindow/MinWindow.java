package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 76 最小覆盖子串
 * 滑动窗口算法：使用tmap保存字符数量，在窗口滑动过程中记录当前窗口字符数量和tmap的匹配数量，当完全匹配时缩减窗口并记录结果。
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        // 定义 rr-rl=s.length+1，这样所有的结果都会小于这个长度，才能被保存。
        int rl = 0, rr = s.length(), count = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.compute(c, (k, v) -> v == null ? 1 : v + 1);
            if (Objects.equals(window.get(c), tmap.get(c))) {
                count++;
                // 缩减窗口
                while (count == tmap.keySet().size()) {
                    // 保存结果
                    if (rr - rl > right - left) {
                        rr = right;
                        rl = left;
                    }

                    char lc = s.charAt(left++);
                    Integer newVal = window.compute(lc, (k, v) -> v - 1);
                    Integer tc = tmap.get(lc);
                    // 如果 tamp 包含这个字符并且因缩减窗口导致窗口字符数量小于 tamp 则递减 count
                    if (tc != null && newVal < tc) {
                        count--;
                    }
                }
            }
        }

        if (rr == s.length()) {
            return "";
        } else {
            return s.substring(rl, rr + 1);
        }
    }
}
