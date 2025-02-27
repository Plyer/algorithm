package cn.flyago.leetcode.lcsaf.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 *
 * 贪心：排序数组，对数组求和 sum。从右到左枚举数组并求子数组的和 subSum，当 subSum 大于剩余元素的和时，即是答案序列。
 */
public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length, subSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            subSum += nums[i];
            res.add(nums[i]);
            if (subSum > sum - subSum) {
                break;
            }
        }
        return res;
    }
}
