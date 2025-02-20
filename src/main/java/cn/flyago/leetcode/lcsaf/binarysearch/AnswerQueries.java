package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 *
 * 二分查找：对 nums 进行排序后求前缀和，枚举 queries：在前缀和中使用二分查找找到小于等于 queries[i] 的最大索引 x，如果 x 越界则子序列长度为零，否则就是 x。
 *
 * 空间优化：前缀和保存到 nums，结果保存到 queries。
 */
public class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = preSum.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (preSum[mid] < queries[i] + 1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int x = l - 1;
            if (x >= 0 && x < preSum.length) {
                res[i] = x;
            }
        }
        return res;
    }
}
