package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 *
 * 二分查找：使用二分找到 >=x 的索引 r，定义另外一个指针 l=r-1。两个指针背向而行，分别跟 x 比较，较接近元素移动指针，直到找到 K 个元素。
 *
 * 题解的二分可以直接找到左边界，没看懂。
 *
 * 另外一种双指针：l=0 r=n-1，两个指针相向移动，分别与 x 比较，移动更不接近的指针，直到剩下 K 个元素。
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int a = l - 1, b = l;
        int c = 0;
        for (; c < k; c++) {
            if (a < 0) {
                b++;
                continue;
            }
            if (b == arr.length) {
                a--;
                continue;
            }
            int z = Math.abs(arr[a] - x) - Math.abs(arr[b] - x);
            if (z <= 0) {
                a--;
            } else {
                b++;
            }
        }
        List<Integer> res = new ArrayList<>(k);
        while (b - a > 1) {
            res.add(arr[++a]);
        }
        return res;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l + 1 > k) {
            int z = Math.abs(arr[l] - x) - Math.abs(arr[r] - x);
            if (z <= 0) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>(k);
        while (l <= r) {
            res.add(arr[l++]);
        }
        return res;
    }
}
