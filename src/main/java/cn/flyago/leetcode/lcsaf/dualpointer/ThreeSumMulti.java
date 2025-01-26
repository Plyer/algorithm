package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 923. 三数之和的多种可能
 *
 * 相向双指针：升序排序数组，枚举第一个值，在第一个值后面的数组进行三数之和的查找。
 */
public class ThreeSumMulti {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int res = 0, n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int c = arr[i];
            if (c + arr[i + 1] + arr[i + 2] > target) break;
            if (c + arr[n - 2] + arr[n - 1] < target) continue;
            for (int l = i + 1, r = n - 1; l < r; ) {
                int sum = c + arr[l] + arr[r];
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    // 这里分两种情况：
                    // 1. arr[l]==arr[r] 此时有 r-l+1 个数，其中所有的两两组合数是结果。
                    // 2. arr[l]!=arr[r] 此时右移左指针直到不等于 arr[l] 并计数，左移右指针直到不等于 arr[r] 并计数，结果数是前面两个计数的乘积。
                    if (arr[l] == arr[r]) {
                        res += (r - l + 1) * (r - l) / (double) 2;
                        res %= 1000000007;
                        break;
                    } else {
                        int j = 1, k = 1;
                        for (l++; l < r && arr[l] == arr[l - 1]; l++, j++) {}
                        for (r--; r >= 0 && arr[r] == arr[r + 1]; r--, k++) {}
                        res = (res + j * k) % 1000000007;
                    }
                }
            }
        }
        return res;
    }
}
