package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery2 {
    // key 是数组元素，value 是二元数组——保存数组索引和到当前索引为止的数组元素数量。value 用 List 存是为了用二分算法找出子数组索引所在处的元素数量。
    private Map<Integer, List<int[]>> map = new HashMap<>();
    public RangeFreqQuery2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<int[]> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(new int[]{i, list.size() + 1});
        }
    }

    public int query(int left, int right, int value) {
        List<int[]> list = map.get(value);
        if (list == null)
            return 0;

        int l = lowerBound(list, left) - 1;
        int r = lowerBound(list, right + 1) - 1;
        int lc = l == -1 ? 0 : list.get(l)[1];
        int rc = r == -1 ? 0 : list.get(r)[1];
        return rc - lc;
    }

    private int lowerBound(List<int[]> list, int x) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[0] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
