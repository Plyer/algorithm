package cn.flyago.leetcode.system;

import java.util.HashMap;
import java.util.Map;

/**
 * 3 无重复字符的最长字串
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        // 初始化窗口
        Map<Character, Integer> window = new HashMap<>();
        // 初始化快慢指针
        int slow = 0, fast = 0;
        // 定义结果值
        int start = 0, end = -1;
        for (; fast < s.length(); fast++) {
            // 快指针的值放进窗口并前进
            char c = s.charAt(fast);
            window.compute(c , (k, v) -> v == null ? 1 : v + 1);
            // 判断窗口的值是否符合要求：本题即为某个字符的数量大于 1
            if (window.getOrDefault(c, 0) > 1) {
                // 不符合要求，缩小窗口
                while (window.get(c) > 1) {
                    // 获取慢指针的值，从窗口移除
                    char sc = s.charAt(slow++);
                    window.compute(sc, (k, v) -> v == null ? null : v - 1);
                }
            }
            if (fast - slow > end - start) {
                start = slow;
                end = fast;
            }
        }
        return end - start + 1;
    }
}
