package cn.flyago.leetcode.lcsaf.greedy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 *
 * 贪心：排序数组后枚举：对于负数直接取反，当遇到非负数时对剩余次数除以 2，剩余的次数对当前非负数和前一个数中的较小值取反。
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == 0) {
                sum += nums[i];
                continue;
            }
            if (nums[i] < 0) {
                sum += -1 * nums[i];
                k--;
            } else {
                k %= 2;
                if (k == 0) {
                    sum += nums[i];
                } else {
                    if (i > 0 && -1 * nums[i - 1] < nums[i]) {
                        sum += 2 * nums[i - 1] + nums[i];
                    } else {
                        sum += -1 * nums[i];
                    }
                    k--;
                }
            }
        }

        if (k > 0) {
            k %= 2;
            if (k > 0) {
                sum += 2 * nums[nums.length - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
