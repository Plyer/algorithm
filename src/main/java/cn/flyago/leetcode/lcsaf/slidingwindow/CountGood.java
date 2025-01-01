package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. 统计好子数组的数目
 * <p>
 * 不定长滑动窗口算法-越长越合法
 * <p>
 * 1. 通过 map 记录 [left,right) 范围内元素的数量，当 right 入窗时满足 i<j且arr[i]==arr[j] 的数量 c+=map[right]，入窗之后 map[right]++。
 * 2. 当 c>=k 时缩减窗口：c-=--map[left++]，缩减完成后 res+=left
 */
public class CountGood {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int c = 0;
        long res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            c += map.getOrDefault(nums[r], 0);
            map.merge(nums[r], 1, Integer::sum);
            while (c >= k) {
                c -= map.merge(nums[l++], -1, Integer::sum);
            }
            res += l;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountGood().countGood(new int[]{2, 1, 3, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 3, 1}, 11));
    }
}
