package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 11. 盛最多水的容器
 *
 * 相向双指针：容器的宽是 r-l，高是 min(arr[l],arr[r])，计算容器容量，移动矮指针使高度增加并和现有的容器容量比较，保存较大值。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        for (int l = 0, r = height.length - 1; l < r; ) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
