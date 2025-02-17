package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * LCP 18. 早餐组合
 *
 * 双序列双指针：升序排序两个数组，枚举主食数组：对于主食价格 a，使用二分查找找到小于等于 x-a 的最大值索引 k，res+=k。
 *
 * 优化题解：定义数组 int[x] nums，索引 i 处保存主食价格小于等于 i 的数量。枚举饮料：对于饮料价格 a，早餐组合数量加上 nums[x-a]。
 */
public class BreakfastNumber {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int res = 0, e = drinks.length;
        for (int i = 0; i < staple.length && staple[i] < x; i++) {
            int maxp = search(drinks, 0, e, x - staple[i]);
            if (maxp == -1) {
                break;
            }
            e = maxp + 1;
            res = (res + maxp + 1) % 1000000007;
        }
        return res;
    }

    private int search(int[] arr, int s, int e, int target) {
        if (s >= e) {
            return -1;
        }
        int l = s, r = e, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (arr[mid] <= target) {
            return mid;
        } else {
            return mid - 1;
        }
    }

    public static void main(String[] args) {
        new BreakfastNumber().breakfastNumber(new int[]{10,20,5}, new int[]{5,5,2}, 15);
    }

    // 优化题解
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int[] nums = new int[x];
        for (int i : staple) {
            if (i < x) {
                nums[i]++;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int res = 0;
        for (int i : drinks) {
            if (i < x) {
                res = (res + nums[x - i]) % 1000000007;
            }
        }
        return res;
    }
}
