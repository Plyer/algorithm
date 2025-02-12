package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 283. 移动零
 *
 * 双指针：l=0 r=0，左指针指向等待存放的索引，枚举右指针找到不等于零的值赋值给左指针，最后把左指针到末尾的值赋值为零。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];
            }
        }
        for (; l < nums.length; l++) {
            nums[l] = 0;
        }
    }
}
