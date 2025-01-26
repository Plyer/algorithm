package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 *
 * 解法：在数组中找三元组，满足 a<=b<=c 且 a+b>c。
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i > 1; i--) {
            if (nums[i - 2] + nums[i - 1] <= nums[i]) continue;
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > nums[i]) {
                    res += r - l;
                    r--;
                } else {
                    for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                }
            }
        }
        return res;
    }
}
