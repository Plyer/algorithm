package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567 字符串的排列
 * 滑动窗口算法：使用s1map保存s1的字符串数量，在窗口滑动过程中，如果窗口字符数量大于s1map字符数量则缩减窗口，如果窗口字符数量和目标长度相等则说明包含排列。
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        // s1map保存s1的字符串数量
        Map<Character, Integer> s1map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1map.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            window.compute(c, (k, v) -> v == null ? 1 : v + 1);
            // 缩减窗口
            while (window.get(c) > s1map.getOrDefault(c, 0)) {
                window.compute(s2.charAt(left++), (k, v) -> v - 1);
            }
            // 如果符合目标长度则说明包含排列
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
}
