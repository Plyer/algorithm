package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 两数之和 II - 输入有序数组
 *
 * 相向双指针：
 * 1. 定义左右指针分别位于数组头和尾。
 * 2. 求双指针元素和，当和大于 target 时右指针左移，当和等于 target 时得到结果，当和小于 target 时做指针右移。重复上述操作直到双指针相遇。
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        for (int l = 0, r = numbers.length - 1; l < r; ) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                for (r--; r > l && numbers[r + 1] == numbers[r]; r--) {}
            } else {
                for (l++; l < r && numbers[l] == numbers[l - 1]; l++) {}
            }
        }
        return null;
    }
}
