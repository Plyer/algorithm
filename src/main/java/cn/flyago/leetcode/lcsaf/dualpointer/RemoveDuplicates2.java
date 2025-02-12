package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * 双指针：l=0 r=1 左指针指向合法数组的末尾，定义 c=1 保存左指针末尾元素的数量，枚举右指针：当 arr[r]==arr[l] 计数 c++，如果 c<=2 把右指针的值赋值给左指针；当 arr[r]!=arr[l] 时把右指针的值赋值给左指针并且 c=1。
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int l = 0, c = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] == nums[l]) {
                c++;
                if (c > 2) {
                    continue;
                }
            } else {
                c = 1;
            }
            nums[++l] = nums[r];
        }
        return ++l;
    }
}
