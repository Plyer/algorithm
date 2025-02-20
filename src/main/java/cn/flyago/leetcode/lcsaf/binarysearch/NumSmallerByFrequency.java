package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 1170. 比较字符串最小字母出现频次
 *
 * 二分查找：先实现函数 f，遍历 words 求函数 f 的结果保存到数组 arr 并升序排序，枚举 queries：在数组 arr 中使用二分查找找到大于 queries[i] 的最小索引 x，没找到就是零，否则就是 arr.len-x。
 */
public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] arr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            arr[i] = f(words[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < queries.length; i++) {
            int f = f(queries[i]);
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] < f + 1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = arr.length - l;
        }
        return res;
    }

    private int f(String s) {
        int res = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < c) {
                c = s.charAt(i);
                res = 1;
            } else if (s.charAt(i) == c) {
                res++;
            }
        }
        return res;
    }
}
