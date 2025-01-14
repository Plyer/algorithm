package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 658. 找到 K 个最接近的元素
 *
 * 双指针：
 * 1. 定义链表保存结果 res。使用二分查找大于等于 X 的最小值，如果找到 X 则加入链表，左右指针分别定义为 X 的左右临近索引；如果找不到 X 则对于找到最小值所在索引的左两个元素和右一个元素和当前最小值这 4 个元素找出其中最接近 X 的两个元素作为左右指针。
 * 2. 循环 K 次，比较左右指针所在元素接近 X 的程度，更接近的元素加入结果链表。
 */
public class FindClosestElements {

    public static void main(String[] args) {
        System.out.println(new FindClosestElements().findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (k == arr.length) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        LinkedList<Integer> res = new LinkedList<>();
        int[] pointers = search(arr, x, res);
        int l = pointers[0];
        int r = pointers[1];
        int initSize = res.size();
        for (int i = 0; i < k - initSize; i++) {
            if (l < 0) {
                res.addLast(arr[r++]);
                continue;
            }
            if (r >= arr.length) {
                res.addFirst(arr[l--]);
                continue;
            }
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                res.addFirst(arr[l--]);
            } else {
                res.addLast(arr[r++]);
            }
        }
        return res;
    }

    private int[] search(int[] arr, int x, List<Integer> res) {
        int s = 0, e = arr.length;
        int mid = 0;
        while (s < e) {
            mid = s + (e - 2) / 2;
            if (arr[mid] < x) {
                s = mid + 1;
            } else if (arr[mid] > x) {
                e = mid;
            } else {
                res.add(x);
                return new int[]{mid -1, mid + 1};
            }
        }

        int i = -1;
        if (arr[mid] < x) {
            // 找到小于 x 的最大值
            i = mid - 1;
        } else {
            // 找到大于 x 的最小值
            i = mid - 2;
        }

        int[] pointers = new int[2];
        int n = arr.length;
        int z = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            i += j;
            if (i < 0 || i >= n || i + 1 >= n) {
                continue;
            }
            int sum = Math.abs(arr[i] - x) + Math.abs(arr[i + 1] - x);
            if (sum < z) {
                pointers[0] = i;
                pointers[1] = i + 1;
                z = sum;
            }
        }
        return pointers;
    }
}
