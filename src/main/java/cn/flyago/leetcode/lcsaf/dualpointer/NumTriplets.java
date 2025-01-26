package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 1577. 数的平方等于两数乘积的方法数
 *
 * 相向双指针：
 * 1. 升序排序两个数组。
 * 2. 分别计算两个模式的三元组，然后求和。
 */
public class NumTriplets {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res = 0;
        if (nums2.length > 1) {
            for (int i = 0; i < nums1.length; i++) {
                long y = (long) nums1[i] * nums1[i];
                int r = nums2.length - 1;
                for (int l = 0; l < r; ) {
                    long z = 0;
                    if ((z = (long) nums2[l] * nums2[l + 1]) > y) break;
                    if ((z = (long) nums2[r - 1] * nums2[r]) < y) break;
                    z = (long) nums2[l] * nums2[r];
                    if (z > y) {
                        r--;
                    } else if (z < y) {
                        l++;
                    } else {
                        if (nums2[l] == nums2[r]) {
                            res += (r - l + 1) * (r - l) / (double) 2;
                            break;
                        } else {
                            int j = 1, k = 1;
                            for (l++; l < r && nums2[l] == nums2[l - 1]; l++, j++) {}
                            for (r--; r >= 0 && nums2[r] == nums2[r + 1]; r--, k++) {}
                            res += j * k;
                        }
                    }
                }
            }
        }

        if (nums1.length > 1) {
            for (int i = 0; i < nums2.length; i++) {
                long y = (long) nums2[i] * nums2[i];
                int r = nums1.length - 1;
                for (int l = 0; l < r; ) {
                    long z = 0;
                    if ((z = (long) nums1[l] * nums1[l + 1]) > y) break;
                    if ((z = (long) nums1[r - 1] * nums1[r]) < y) break;
                    z = (long) nums1[l] * nums1[r];
                    if (z > y) {
                        r--;
                    } else if (z < y) {
                        l++;
                    } else {
                        if (nums1[l] == nums1[r]) {
                            res += (r - l + 1) * (r - l) / (double) 2;
                            break;
                        } else {
                            int j = 1, k = 1;
                            for (l++; l < r && nums1[l] == nums1[l - 1]; l++, j++) {}
                            for (r--; r >= 0 && nums1[r] == nums1[r + 1]; r--, k++) {}
                            res += j * k;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 求数组中小于 target 的最大值
     * @param arr
     * @param target
     * @return
     */
    private int maxLess(int[] arr, int target) {
        int l = 0, r = arr.length, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (arr[mid] >= target) {
            return Math.max(0, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumTriplets().numTriplets(new int[]{43024,99908}, new int[]{1864}));
    }
}
