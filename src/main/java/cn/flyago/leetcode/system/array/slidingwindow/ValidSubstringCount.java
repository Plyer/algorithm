package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3298. 统计重新排列后包含另一个字符串的子字符串数目 II
 *
 * 不定长滑动窗口算法-越长越合法
 *
 * 1. 使用 map 记录 word2 的字符数量。
 * 2. 对 word1 使用滑动窗口算法，入窗时 map.computeIfPresent[right]--，当 map.value==0 时计数 c++。
 * 3. 当 c==map.size 时缩减窗口：map.computeIfPresent[left]++，当 map.value==1 时 c--。
 * 4. 记录结果 res+=left
 */
public class ValidSubstringCount {
    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            map.merge(word2.charAt(i), 1, Integer::sum);
        }

        long res = 0;
        int c = 0;
        for (int l = 0, r = 0; r < word1.length(); r++) {
            Integer newVal = map.computeIfPresent(word1.charAt(r), (k, ov) -> --ov);
            if (newVal != null && newVal == 0) {
                c++;
            }
            while (c == map.size()) {
                Integer z = map.computeIfPresent(word1.charAt(l++), (k, ov) -> ++ov);
                if (z != null && z == 1) {
                    c--;
                }
            }
            res += l;
        }
        return res;
    }
}
