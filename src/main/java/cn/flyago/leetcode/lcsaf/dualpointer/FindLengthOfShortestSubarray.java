package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 *
 * 双指针：
 * 从右往左找非递减数组，然后在从左往右找递增数组并与尾部的非递减数组组合成整个数组，找到这个数组的最大值即可找到删除的最小值。
 * 从右到左找到非递减数组的最大边界 r，枚举 l：当 l 处于非递减情况时，向右移动 r 直到 arr[r]>=arr[l]，此时 r-l-1 就是需要删除的长度，记录过程中的最短长度。
 */
public class FindLengthOfShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int r = n - 1;
        for (; r >= 1 && arr[r - 1] <= arr[r]; r--) {}

        int res = r;
        if (r == 0) {
            return 0;
        }
        for (int l = 0; l < n; l++) {
            if (l > 0 && arr[l] < arr[l - 1]) {
                break;
            }
            while (r < n && arr[r] < arr[l]) {
                r++;
            }
            res = Math.min(res, r - l - 1);
        }
        return res;
    }
}
