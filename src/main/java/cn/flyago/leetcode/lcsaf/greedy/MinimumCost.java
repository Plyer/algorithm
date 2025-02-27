package cn.flyago.leetcode.lcsaf.greedy;

import java.util.Arrays;

/**
 * 3010. 将数组分成最小总代价的子数组 I
 *
 * 贪心：数组第一个元素必定选中，对[2,n-1]升序排序，获取前两个元素和加上第一个元素即为最小代价。
 *
 * 优化：从 O(nlogn) 到 O(n)，遍历[1,n-1] 求最小和次小值。
 */
public class MinimumCost {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }

    public int minimumCost2(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < first) {
                second = first;
                first = x;
            } else if (x < second) {
                second = x;
            }
        }
        return nums[0] + first + second;
    }
}