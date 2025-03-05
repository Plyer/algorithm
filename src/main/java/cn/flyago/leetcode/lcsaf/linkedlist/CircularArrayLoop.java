package cn.flyago.leetcode.lcsaf.linkedlist;

import java.awt.event.WindowListener;

/**
 * 457. 环形数组是否存在循环
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int signI = nums[i] >>> 31;
            for (int k = 1, nextIdx = i; k <= n; k++) {
                nextIdx = nums[nextIdx] + nextIdx;
                if (nextIdx < 0) {
                    nextIdx -= ((nextIdx+1) / n - 1) * n;
                } else {
                    nextIdx %= n;
                }
                if (nums[nextIdx] >>> 31 != signI) {
                    break;
                }
                if (nextIdx == i) {
                    if (k > 1) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }
}
