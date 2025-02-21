package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.*;

/**
 * 1818. 绝对差值和
 *
 * 二分查找：先对 nums1 拷贝并排序，然后在枚举求绝对差值和的过程中在 nums1 中求出最接近 nums2[i] 的值并求差值，对两个差值在做减法得到 x，在枚举过程中保留最大的差值 x，最终的答案就是绝对差值和 sum-x。
 */
public class MinAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] t = new int[n];
        System.arraycopy(nums1, 0, t, 0, n);
        Arrays.sort(t);

        int sum = 0, x = 0;
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + abs) % 1000000007;

            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (t[mid] < nums2[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            int c;
            if (l < n && r >= 0) {
                c = Math.min(Math.abs(t[l] - nums2[i]), Math.abs(t[r] - nums2[i]));
            } else if (l == n) {
                c = Math.abs(t[r] - nums2[i]);
            } else {
                c = Math.abs(t[l] - nums2[i]);
            }
            x = Math.max(x, abs - c);
        }
        sum = (sum - x + 1000000007) % 1000000007;
        return sum;
    }
}
