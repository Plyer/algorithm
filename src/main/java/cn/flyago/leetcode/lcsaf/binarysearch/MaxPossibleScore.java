package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 3281. 范围内整数的最大得分
 *
 * 二分答案：得分越大，最小绝对差越小，符合单调性，可以使用二分算法。
 * 1. 对得分进行二分，得分范围 [0,2*10^9]。排序 start 数组。
 * 2. check 函数：枚举排序后的 start 数组，令选中的两个相邻整数的差取 >=m 的最小值，如果某个范围无法满足上述要求则返回 false。
 */
public class MaxPossibleScore {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int l = 1, r = start[start.length - 1] - start[0] + d;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(start, d, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int[] start, int d, int mid) {
        for (int i = 0, cur = start[0]; i < start.length - 1; i++) {
            if (start[i + 1] - cur + d < mid) {
                return false;
            }
            cur = start[i + 1] - cur >= mid ? start[i + 1] : cur + mid;
        }
        return true;
    }
}
