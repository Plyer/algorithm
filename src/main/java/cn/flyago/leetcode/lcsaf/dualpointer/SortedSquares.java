package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 977. 有序数组的平方
 *
 * 相向双指针：定义 l=0、r=n-1、结果数组 res[]，当 l<=r 时循环执行 if(|arr[l]|>|arr[r]|) res[i--]=arr[l++]的平方 else res[i--]=arr[r--]的平方。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int l = 0, r = n - 1, i = r; l <= r;) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i--] = (int) Math.pow(nums[l++], 2);
            } else {
                res[i--] = (int) Math.pow(nums[r--], 2);
            }
        }
        return res;
    }
}
