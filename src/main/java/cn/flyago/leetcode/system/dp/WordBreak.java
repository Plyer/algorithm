package cn.flyago.leetcode.system.dp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 139 单词拆分:
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 题解：
 * 1. 状态：单词
 * 2. 选择：字典的单词在字符串的开头或者结尾时，对应删除此单词的子问题。
 * 3. dp 函数：boolean dp(String s, List<String> wordDict)
 * 4. base case: wordDict 里的所有单词在 dp 函数里为 true
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = wordDict.stream().collect(Collectors.toMap(i -> i, v -> true));
        return dp(s, wordDict, memo);
    }

    public boolean dp(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (s.isEmpty()) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean res = false;
        for (String word : wordDict) {
            String subStr = null;
            if (s.startsWith(word)) {
                subStr = s.substring(word.length());
            } else if (s.endsWith(word)) {
                subStr = s.substring(0, s.length() - word.length());
            }
            if (subStr != null) {
                boolean sub = memo.containsKey(subStr) ? memo.get(subStr) : dp(subStr, wordDict, memo);
                res = sub;
                if (res) {
                    break;
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
