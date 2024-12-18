package cn.flyago.leetcode.system.array;

/**
 * 11 盛最多水的容器
 *
 * 双指针法。两个指针初始位于数组开头和末尾，表示此时容器的宽为最大值，此时仅有两种选择：移动高指针、移动矮指针，这两种操作使宽度减一，高度发生变化。
 * 但是容器的面积仅由矮指针决定，移动高指针使最大高度发生变化，只可能使面积变小；而移动矮指针才可能使面积变大。所以仅移动矮指针，在过程中记录最大面积即可。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int area = 0;
        for (int l = 0, r = height.length - 1; l < r; ) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
