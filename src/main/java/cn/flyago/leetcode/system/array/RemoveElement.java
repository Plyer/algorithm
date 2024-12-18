package cn.flyago.leetcode.system.array;

/**
 * 27 移除元素
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;// 定义左指针指向待赋值的索引
        for (int right = 0; right < nums.length; right++) {
            if (val != nums[right]) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
