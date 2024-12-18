package cn.flyago.leetcode.system;

public class ClimbStairs {
    public int climbStairs(int n) {
        int arrLen = Math.max(n + 1, 3);
        int[] arr = new int[arrLen];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
