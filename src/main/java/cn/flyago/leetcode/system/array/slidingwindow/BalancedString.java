package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1234. 替换子串得到平衡字符串
 *
 * 不定长滑动窗口算法：
 * 1. 先遍历字符串获取每个字符的数量 map，对每个数量减去 s.length/4，其中的正数表示过多的字符需要被转换。也就是说问题转换成求至少有正数个对应字符的最小子串。
 * 2. 对进入窗口的字符在 map 中的数量进行递减并记录数组元素变成零的数量 c，当 map 所有的元素小于等于零即 c==map.size() 时满足替换要求，缩减窗口并记录结果。
 */
public class BalancedString {
    public int balancedString(String s) {
        int base = s.length() / 4;
        Map<Character, Integer> map = new HashMap<>(4);
        int maxNum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer val = map.merge(s.charAt(i), 1, Integer::sum);
            maxNum = Math.max(maxNum, val);
        }
        if (maxNum == base) {
            return 0;
        }

        int c = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue() - base;
            map.put(entry.getKey(), value);
            if (value <= 0) c++;
        }

        int res = s.length() + 1;
        for (int l = 0, r = 0; r < s.length(); r++) {
            Integer val = map.merge(s.charAt(r), -1, Integer::sum);
            if (val == 0) c++;
            while (c == map.size()) {
                res = Math.min(res, r - l + 1);
                Integer newVal = map.merge(s.charAt(l), 1, Integer::sum);
                if (newVal == 1) c--;
                l++;
            }
        }
        return res;
    }
}
