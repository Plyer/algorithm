package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 *
 * 不定长滑动窗口算法：问题可以转换成求至多包含两个不同元素的子数组最大长度。
 */
public class TotalFruit {
    public int totalFruit(int[] fruits) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(2);
        for (int r = 0, l = 0; r < fruits.length; r++) {
            int c = fruits[r];
            while (map.size() == 2 && !map.containsKey(c)) {
                int left = fruits[l];
                if (map.merge(left, -1, Integer::sum) == 0) {
                    map.remove(left);
                }
                l++;
            }
            map.merge(c, 1, Integer::sum);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
