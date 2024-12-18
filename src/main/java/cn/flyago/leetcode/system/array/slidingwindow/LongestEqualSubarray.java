package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 *
 * 不定长滑动窗口算法：
 * 1. 把相同元素分组，用 MAP 记录相同元素的索引，对 MAP 的每个 value 使用滑动窗口计算。
 * 2. 如果 left 和 right 窗口表示未删除前的等值子数组，那么等值子数组的长度是 value[right]-value[left]+1，此时等值的数量是 right-left+1，那么删除的元素数量则是 value[right]-value[left]-right+left。
 * 3. 为了简化代码实现，在 value 中保存 value[i]-i 即元素原始索引减去元素在value数组中的索引，此时删除元素数量就是 value[right]-value[left]。
 * 4. 当 value[right]-value[left]>k 时缩减窗口，保存等值子数组长度 right-left+1。
 */
public class LongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            map.putIfAbsent(nums.get(i), new ArrayList<>());
            List<Integer> list = map.get(nums.get(i));
            list.add(i - list.size());
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() <= res) {
                continue;
            }
            for (int l = 0, r = 0; r < value.size(); r++) {
                while (value.get(r) - value.get(l) > k) {
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
