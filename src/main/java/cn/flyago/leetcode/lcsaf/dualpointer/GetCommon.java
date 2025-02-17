package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 2540. 最小公共值
 *
 * 双序列双指针：分别在两个序列定义指针 i j，比较指针 i j 处的值：较小值指针往右移动，如果越界则无公共值；相等时是最小公共值。
 */
public class GetCommon {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
