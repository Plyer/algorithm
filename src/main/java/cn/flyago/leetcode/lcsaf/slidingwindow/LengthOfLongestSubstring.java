package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3 无重复字符的最长字串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, rl = -1, rr = -2;
        Map<Character, Integer> map = new HashMap<>();
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            map.compute(c, (k, v) -> v == null ? 1 : v+1);
            if (map.get(c) == 2) {
                for (; map.get(c) != 1; map.compute(s.charAt(left++), (k, v) -> v - 1)) {}
            } else if (right - left > rr - rl) {
                rl = left;
                rr = right;
            }
        }
        return rr - rl + 1;
    }
}
