package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438 找到字符串中所有字母异位词
 * 滑动窗口算法：使用pmap保存目标字符串的字符数量，在滑动过程中如果窗口字符数量大于pmap字符数量缩减窗口，当窗口字符串长度等于目标长度时保存结果并右移左指针。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // pmap 保存目标字符串的字符数量
        Map<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pmap.compute(p.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.compute(c, (k, v) -> v == null ? 1 : v + 1);
            // 缩减窗口
            while (window.get(c) > pmap.getOrDefault(c, 0)) {
                window.compute(s.charAt(left), (k, v) -> v - 1);
                left++;
            }
            // 符合目标长度保存结果
            if (right - left + 1 == p.length()) {
                res.add(left);
                window.compute(s.charAt(left), (k, v) -> v - 1);
                left++;
            }
        }
        return res;
    }
}
