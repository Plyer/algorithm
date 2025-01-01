package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 不定长滑动窗口算法：使用 map 保存字符串 t 的字符数量，对于窗口内的元素缩减 map 的 value 并计算 value=0 的数量 c 直到 c==map.size 时窗口覆盖 t，缩减窗口找到最小子串。
 */
public class MinWinow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        String res = s + "1";
        int c = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            Integer newVal = map.computeIfPresent(s.charAt(r), (k, oldVal) -> --oldVal);
            if (newVal != null && newVal == 0) c++;
            int preC = c;
            while (c == map.size()) {
                newVal = map.computeIfPresent(s.charAt(l++), (k, oldVal) -> ++oldVal);
                if (newVal != null && newVal == 1) c--;
            }
            if (preC == map.size() && r - l + 2 < res.length()) {
                res = s.substring(l - 1, r + 1);
            }
        }
        return res.length() <= s.length() ? res : "";
    }
}
