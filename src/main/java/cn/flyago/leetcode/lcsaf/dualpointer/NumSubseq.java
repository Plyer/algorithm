package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 1498. 满足条件的子序列数目
 *
 * 相向双指针：升序排序数组，定义左右指针 l=0 r=n-1，当 l<=r 时求双指针的和 sum，如果 sum<=target，res+=2^(r-l) 且 l++，如果 sum>target，r--。
 */
public class NumSubseq {
    public int numSubseq(int[] nums, int target) {
        // 预先把 2 的 n 次方的值保存在数组中，加快速度。
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pow[i] = pow[i - 1] * 2 % 1000000007;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                res += pow[r - l];
                res %= 1000000007;
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
