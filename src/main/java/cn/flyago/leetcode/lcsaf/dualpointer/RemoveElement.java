package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 27. 移除元素
 *
 * 双指针：l=0 r=0，l 指针指向等待存放不等于 val 的元素，枚举 r 指针找到不等于 val 的元素并赋值给 l 指针。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}
