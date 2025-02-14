package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 905. 按奇偶排序数组
 * <p>
 * 双指针：l=0 r=0，左指针指向等待存放偶数的索引，枚举右指针找到偶数跟左指针元素进行交换。
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 0) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++;
            }
        }
        return nums;
    }
}
