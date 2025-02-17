package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 1855. 下标对中的最大距离
 * <p>
 * 双序列双指针：p1=0 p2=0，枚举 nums1：对于每个 nums1 的元素，在 nums2 中找到索引和值都大于等于其的元素，保存距离。枚举直到 p2 到达末尾或者 nums2.len-p1-1<maxDistance。
 */
public class MaxDistance {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int p1 = 0, p2 = 0; p1 < nums1.length && p2 < nums2.length && nums2.length - p1 - 1 > res; p1++) {
            while (p2 < nums2.length && nums2[p2] >= nums1[p1]) {
                res = Math.max(res, p2 - p1);
                p2++;
            }
        }
        return res;
    }
}
