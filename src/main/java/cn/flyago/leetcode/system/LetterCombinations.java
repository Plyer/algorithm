package cn.flyago.leetcode.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例: 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author Lvjinglu
 * @create 2021/5/31 17:04
 * @since 1.0.0
 */
public class LetterCombinations {

    public List<String> solution(String digits) {
        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        if (digits == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            int num = Character.getNumericValue(c);
            char[] chars = map.get(c);
            if (chars != null) {
                for (char aChar : chars) {
                    
                }
            }
        }
        return null;
    }
}
