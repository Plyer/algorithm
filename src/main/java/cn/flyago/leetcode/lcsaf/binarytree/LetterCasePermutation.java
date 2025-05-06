package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */
public class LetterCasePermutation {
    List<String> res = new ArrayList<>();
    char[] arr;
    public List<String> letterCasePermutation(String s) {
        arr = new char[s.length()];
        dfs(0, s);
        return res;
    }

    private void dfs(int i, String s) {
        if (i == s.length()) {
            res.add(new String(arr));
            return;
        }
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            arr[i] = c;
            dfs(i + 1, s);
        } else {
            arr[i] = Character.toLowerCase(c);
            dfs(i + 1, s);
            arr[i] = Character.toUpperCase(c);
            dfs(i + 1, s);
        }
    }
}
