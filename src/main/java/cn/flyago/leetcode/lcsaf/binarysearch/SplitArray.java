package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 410. 分割数组的最大值
 *
 * 二分答案：和越小，分割数组的段数越多，最终达到分割成 k 个的极限，满足单调性，可以使用二分算法。
 * 1. 二分和的最大值，范围是 [max(nums),sum(nums)]。
 * 2. check 函数：贪心的分割 nums 数组求段数，如果段数小于等于 k 则符合要求。
 */
public class SplitArray {

    public static void main(String[] args) {
        System.out.println(new SplitArray().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length, sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int l = max, r = sum;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(nums, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l > sum ? -1 : l;
    }

    private boolean check(int[] nums, int k, int mid) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt <= k;
    }
}
