package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 88. 合并两个有序数组
 *
 * 双序列双指针：复制 nums1，在副本数组和 nums2 中分别定义指针 i=0 j=0，比较指针的值，较小值放到 nums1，直到所有元素都已合并。
 *
 * 优化题解：从右往左比较两个数组，较大的值放到 nums1 末尾，当相等时把 nums2 的值放入 nums1。
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tnums1 = new int[m];
        System.arraycopy(nums1, 0, tnums1, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (tnums1[i] < nums2[j]) {
                nums1[k++] = tnums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = tnums1[i++];
        }
        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }

    /**
     * 优化题解
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int p1 = m - 1, p2 = n - 1, p = m + n - 1; p2 >= 0; ) {
            // 注意判断 p1 是否越界
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
    }
}
