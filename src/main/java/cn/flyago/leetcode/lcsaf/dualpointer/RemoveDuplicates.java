package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 26. 删除有序数组中的重复项
 *
 * 双指针：l=0 r=1，左指针指向唯一元素的末尾，枚举右指针：当 arr[r]!=arr[l] 时 arr[++l]=arr[r]。
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[++l] = nums[r];
            }
        }
        return ++l;
    }
}
