package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 3143. 正方形中的最多点数
 *
 * 灵山的题解在 check 中不做排序，并且在 check 实现中保存点数最大值，定义 boolean check，代码简单。
 *
 * <p>
 * 二分查找：正方形越大，包含的点数越多，越容易重复也越接近极限值，符合单调性，可以使用二分算法。
 * 1. 定义 x=正方形边长的1/2，对其进行二分，范围是 [0,abs(max(points[i][j]))。
 * 2. check 函数：先根据 points[i][0] 排序 points 和 String，然后使用二分查找找到 -m<=points[i][0]<=m 的点，判断这些点的纵坐标是否在[-m,m]范围内，对范围内的点判断标签是否重复，不重复则返回正方形内点的个数，否则返回 -1。
 */
public class MaxPointsInsideSquare {
    int[][] t;
    int[] cnt = new int[26];
    char[] chars;
    char[] tchars;

    public int maxPointsInsideSquare(int[][] points, String s) {
        chars = s.toCharArray();
        tchars = new char[chars.length];
        int n = points.length;
        t = new int[n][];
        sort(points, 0, n);
        s = new String(chars);
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            max = Math.max(max, Math.max(Math.abs(point[0]), Math.abs(point[1])));
        }

        int l = 0, r = max, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = check(points, s, mid);
            if (cnt > -1) {
                res = Math.max(res, cnt);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    private int check(int[][] points, String s, int m) {
        int n = points.length;
        int l = search(points, -m);
        if (l == n) {
            return 0;
        }
        int r = search(points, m + 1) - 1;
        if (r < 0) {
            return 0;
        }
        // 那么 points[l,r] 都是横坐标符合正方形的点，接下来判断纵坐标和标签。
        Arrays.fill(cnt, 0);
        int sum = 0;
        for (int i = l; i <= r; i++) {
            int y = points[i][1];
            if (Math.abs(y) > m) {
                continue;
            }
            if (++cnt[s.charAt(i) - 'a'] > 1) {
                return -1;
            }
            sum++;
        }
        return sum;
    }

    private int search(int[][] points, int t) {
        int n = points.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (points[mid][0] >= t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private void sort(int[][] points, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int m = l + (r - l) / 2;
        sort(points, l, m);
        sort(points, m, r);

        System.arraycopy(points, l, t, l, r - l);
        System.arraycopy(chars, l, tchars, l, r - l);
        int i = l, j = m, k = l;
        while (i < m && j < r) {
            if (t[i][0] < t[j][0]) {
                points[k] = t[i];
                chars[k] = tchars[i];
                k++;
                i++;
            } else {
                points[k] = t[j];
                chars[k] = tchars[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            points[k] = t[i];
            chars[k] = tchars[i];
            k++;
            i++;
        }
        while (j < r) {
            points[k] = t[j];
            chars[k] = tchars[j];
            k++;
            j++;
        }
    }
}
