package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 1471. 数组中的 k 个最强值
 * <p>
 * 相向双指针：
 * 1. 对数组进行排序，找出中位数 mid。
 * 2. 定义左右指针分别是数组头和尾，比较左右指针的强度，更强的值加入结果，直到拿到 K 个值。
 * <p>
 * 优化时间复杂度：当某个指针的值等于中位数，另一个指针的值直接加入结果。
 * 优化空间复杂度：不定义新的结果数组，在循环中只移动指针，最终把 (r,n-1) 的元素移动到 l 的位置。数组的前 K 个数就是答案，leetcode 判题错误是因为判题的方式不支持这种答案。
 */
public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int[] res = new int[k];
        for (int l = 0, r = arr.length - 1, i = 0; i < k; i++) {
            if (arr[l] == mid) {
                res[i] = arr[r--];
                continue;
            }
            if (arr[r] == mid) {
                res[i] = arr[l++];
                continue;
            }
            int ls = Math.abs(arr[l] - mid);
            int rs = Math.abs(arr[r] - mid);
            if (ls > rs) {
                res[i] = arr[l++];
            } else if (ls < rs) {
                res[i] = arr[r--];
            } else {
                if (r > l) {
                    res[i] = arr[r--];
                } else {
                    res[i] = arr[l++];
                }
            }
        }
        return res;
    }

    public int[] getStrongest2(int[] arr, int k) {
        if (k == arr.length) {
            return arr;
        }
        Arrays.sort(arr);
        int mid = arr[(arr.length - 1) / 2];
        int l = 0, r = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (arr[r] == mid) {
                l++;
                continue;
            }
            if (arr[l] == mid) {
                r--;
                continue;
            }
            int ls = Math.abs(arr[l] - mid);
            int rs = Math.abs(arr[r] - mid);
            if (ls > rs) {
                l++;
            } else if (ls < rs) {
                r--;
            } else {
                if (r > l) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        if (r < arr.length - 1) {
            System.arraycopy(arr, r + 1, arr, l, arr.length - 1 - r);
        }
        return arr;
    }
}
