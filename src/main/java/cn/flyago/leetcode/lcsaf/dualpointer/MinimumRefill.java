package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 2105. 给植物浇水 II
 * <p>
 * 相向双指针：
 * 1. 定义 l=0、r=n-1、加水次数 c=0，循环浇水，循环条件 l<r：if(arr[l]>curCapA) c++ and curCapA=capA-arr[l]，r 同上。
 * 2. if (l==r) A 进行浇水。
 */
public class MinimumRefill {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int c = 0, curA = capacityA, curB = capacityB;
        int l = 0, r = plants.length - 1;
        for (; l < r; l++, r--) {
            if (plants[l] > curA) {
                c++;
                curA = capacityA - plants[l];
            } else {
                curA -= plants[l];
            }
            if (plants[r] > curB) {
                c++;
                curB = capacityB - plants[r];
            } else {
                curB -= plants[r];
            }
        }

        if (l == r && Math.max(curA, curB) < plants[l]) {
            c++;
        }
        return c;
    }
}
