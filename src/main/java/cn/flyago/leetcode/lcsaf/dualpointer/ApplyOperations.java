package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 2460. 对数组执行操作
 *
 * 双指针
 */
public class ApplyOperations {
    public int[] applyOperations(int[] nums) {
        for (int l = 0, r = 1; l < nums.length - 1; l++, r++) {
            if (nums[l] == nums[r]) {
                nums[l] = 2 * nums[l];
                nums[r] = 0;
            }
        }

        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                l++;
            }
        }
        return nums;
    }
}
