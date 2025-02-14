package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 922. 按奇偶排序数组 II
 *
 * 双指针：一个指针指向偶数索引，枚举奇数索引：发现偶数则交换到偶数索引的下一个奇数。
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; j < nums.length; j += 2) {
            if (nums[j] % 2 == 0) {
                while (nums[i] % 2 == 0) {
                    i += 2;
                }
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i += 2;
            }
        }
        return nums;
    }
}
