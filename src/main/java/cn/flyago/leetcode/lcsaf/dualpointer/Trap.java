package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 42. 接雨水
 *
 * 多种解法：
 * 1. 前后缀数组：定义前缀数组 preMax[i] 是从索引 0 到索引 i 的最大值，定义后缀数组 sufMax[i] 是从索引 i 到 n-1 的最大值。枚举数组 arr，arr[i] 的雨水容量就是 min(preMax[i],sufMax[i])-arr[i]。
 * 2. 相向双指针：定义左右指针 l=0 r=n-1，定义 preMax 是索引 0 到 l 的最大值，定义 sufMax 是索引 r 到 n-1 的最大值，左右指针中高度较矮的雨水容量是对应的 max-arr[x]。
 */
public class Trap {
    /**
     * 相向双指针
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0, n = height.length;
        int preMax = 0, sufMax = 0;
        for (int l = 0, r = n - 1; l < r; ) {
            preMax = Math.max(preMax, height[l]);
            sufMax = Math.max(sufMax, height[r]);
            res += preMax < sufMax ? preMax - height[l++] : sufMax - height[r--];
        }
        return res;
    }

    /**
     * 前后缀数组
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            preMax[i] = max;
        }

        max = 0;
        int[] sufMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            sufMax[i] = max;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return res;
    }
}
