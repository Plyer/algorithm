package cn.flyago.leetcode.lcsaf.slidingwindow;

import cn.flyago.leetcode.base.MonotonicQueue;

import java.util.Arrays;

/**
 * 239 滑动窗口最大值
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue<Integer> pq = new MonotonicQueue<>();
        int[] res = new int[nums.length - k + 1];
        for (int r = 0, j = 0; r < nums.length; r++) {
            pq.push(nums[r]);
            if (r >= k - 1) {
                res[j++] = pq.max();
                pq.poll(nums[r - k + 1]);
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        MonotonicQueue<Integer> pq = new MonotonicQueue<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.push(nums[i]);
        }
        res[0] = pq.max();

        for (int r = k, j = 1; r < nums.length; r++) {
            pq.push(nums[r]);
            pq.poll(nums[r - k]);
            res[j++] = pq.max();
        }
        return res;
    }
}
