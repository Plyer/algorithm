package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * LCP 28. 采购方案
 *
 * 相向双指针：
 * 1. 数组升序排序，定义左右指针 l=0 r=n-1
 * 2. 当 l<r 时循环执行：求左右指针元素和 sum，当 sum<=target 时 res+=r-l，l++；否则 r-- 直到不同元素。
 */
public class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int l = 0, r = nums.length - 1; l < r; ) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                res = (res + r - l) % 1000000007;
                l++;
            } else {
                for (r--; r > l && nums[r] == nums[r + 1]; r--) {}
            }
        }
        return res;
    }
}
