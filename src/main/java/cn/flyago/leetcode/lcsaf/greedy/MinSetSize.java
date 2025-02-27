package cn.flyago.leetcode.lcsaf.greedy;

import java.util.*;

/**
 * 1338. 数组大小减半
 *
 * 贪心：对数组元素计数，按数量排序，然后按数量从大到小求数量和，当数量和大于等于数组大小一半时得到答案。
 */
public class MinSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        ArrayList<Integer> cnts = new ArrayList<>(map.values());
        Collections.sort(cnts);
        int res = 0, cnt = 0, i = cnts.size() - 1;
        while (cnt < arr.length / 2) {
            cnt += cnts.get(i--);
            res++;
        }
        return res;
    }
}
