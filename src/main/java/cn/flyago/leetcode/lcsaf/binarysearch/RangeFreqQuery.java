package cn.flyago.leetcode.lcsaf.binarysearch;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 2080. 区间内查询数字的频率
 *
 * 二分查找：统计位置+二分查找。
 * 1. 统计数组中每个元素的下标位置，保存到 map。
 * 2. 对于每个 query，用 value 在 map 中找到下标数组，因为下标数组是有序的，使用二分查找在下标数组找到 >=left 和 >right 的索引 p q，如果找不到则两个索引都是下标数组的长度，如果找到的话频率就是 q-p（找不到也是如此）。
 */
public class RangeFreqQuery {
    Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (right < left) {
            return 0;
        }
        List<Integer> list = map.get(value);
        if (list == null) {
            return 0;
        }
        return search(list, right + 1) - search(list, left);
    }

    public int search(List<Integer> arr, int value) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
