package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1297. 子串的最大出现次数
 *
 * 定长滑动窗口算法：如果有长度大于minSize的子串重复 c 次，那么也一定有长度等于minSize的重复次数>=c。所以问题可以转换成求窗口长度为 minSize 的子串最大出现次数。对符合要求的子串使用 map 进行计数求最大次数。
 */
public class MaxFreq {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>(maxLetters);
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            window.merge(s.charAt(i), 1, Integer::sum);
            if (i < minSize - 1) {
                continue;
            }
            if (window.size() <= maxLetters) {
                Integer c = map.merge(s.substring(i - minSize + 1, i + 1), 1, Integer::sum);
                res = Math.max(res, c);
            }

            char out = s.charAt(i - minSize + 1);
            if (window.merge(out, -1, Integer::sum) == 0) {
                window.remove(out);
            }
        }
        return res;
    }
}
