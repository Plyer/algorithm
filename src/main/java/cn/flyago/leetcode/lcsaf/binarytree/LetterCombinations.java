package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * <p>
 * 回溯三问：
 * 1. 当前操作：枚举当前 i 索引所在的数字对应的字母。
 * 2. 子问题：大于 i 索引的数字字母组合。
 * 3. 下一个子问题：大于 i+1 索引的数组字母组合。
 */
public class LetterCombinations {
    List<String> res = new ArrayList<>();
    char[] arr;
    String[] map = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return new ArrayList<>();
        arr = new char[n];
        dfs(0, digits);
        return res;
    }

    private void dfs(int i, String digits) {
        if (i == digits.length()) {
            res.add(new String(arr));
            return;
        }
        String str = map[Character.digit(digits.charAt(i), 10) - 1];
        for (int j = 0; j < str.length(); j++) {
            arr[i] = str.charAt(j);
            dfs(i + 1, digits);
        }
    }

    public static void main(String[] args) {
        System.out.println(Character.digit('9', 10));
    }
}
