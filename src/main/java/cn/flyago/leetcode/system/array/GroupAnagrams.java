package cn.flyago.leetcode.system.array;

import java.util.*;

/**
 * 49 字母异位词
 * 异位词按字母序排序后都是同一个字符串，根据这个规则来进行分类存储到map，最后输出map的values。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> strings = map.computeIfAbsent(key, k -> new ArrayList<>());
            strings.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
