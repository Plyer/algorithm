package cn.flyago.leetcode.lcsaf.freqdatastruct;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 *
 * 仅需在 map 中保存 j 之前的 k 个元素，枚举 j 时判断 map 中是否存在相同的值，存在则返回 true。
 *
 * 优化：使用 set 来保存前 k 个元素，因为如果前 k 个元素有重复值那么就已经返回 true，没有重复的话就可以直接移除 i-k 所在的元素。
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(x)) {
                return true;
            }
            map.merge(x, 1, Integer::sum);
            if (i >= k) {
                if (map.merge(nums[i - k], -1 , Integer::sum) == 0) {
                    map.remove(nums[i - k]);
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
