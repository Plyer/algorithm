package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 每个字符最多出现两次的最长子字符串
 *
 * 不定长滑动窗口算法：使用 map 保存窗口元素数量，对不符合要求的情况缩减窗口至符合条件，保存结果。
 */
public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.merge(c, 1, Integer::sum);
            while (map.get(c) > 2) {
                map.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
