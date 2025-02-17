package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 2570. 合并两个二维数组 - 求和法
 *
 * 双序列双指针
 */
public class MergeArrays {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[][] res = new int[nums1.length + nums2.length][];
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] < nums2[p2][0]) {
                res[p++] = nums1[p1++];
            } else if (nums1[p1][0] > nums2[p2][0]) {
                res[p++] = nums2[p2++];
            } else {
                res[p++] = new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]};
                p1++;
                p2++;
            }
        }
        while (p1 < nums1.length) {
            res[p++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            res[p++] = nums2[p2++];
        }

        int[][] ans = new int[p][];
        System.arraycopy(res, 0, ans, 0, p);
        return ans;
    }
}
