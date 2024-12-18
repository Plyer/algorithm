package cn.flyago.leetcode.system.array;

/**
 * 26 删除有序数组中的重复项
 */
public class RemoveDuplicates {
    // 双指针法：左指针指向不重复的最后一个元素(初始化为数组第一个元素)，右指针从索引1开始遍历，当找到与左指针元素不相等的值时，左指针右移并把右指针的值赋值到左指针。
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }
}
