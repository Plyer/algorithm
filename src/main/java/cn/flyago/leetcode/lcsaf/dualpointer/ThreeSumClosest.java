package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 相向双指针：参考三数之和，使用一个额外变量来记录三数之和和 target 差的绝对值，当绝对值最小时找到最接近的值。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int x = Integer.MAX_VALUE;
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = 0;
            if ((sum = nums[i] + nums[i + 1] + nums[i + 2]) > target) {
                if (Math.abs(sum - target) < x) {
                    return sum;
                }
                break;
            }
            if ((sum = nums[i] + nums[n - 2] + nums[n - 1]) < target) {
                int abs = Math.abs(sum - target);
                if (abs < x) {
                    x = abs;
                    res = sum;
                }
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = nums[l] + nums[r] + nums[i];
                if (s == target) {
                    return s;
                } else if (s > target) {
                    int abs = Math.abs(s - target);
                    if (abs < x) {
                        x = abs;
                        res = s;
                    }
                    for (r--; r > l && nums[r] == nums[r + 1]; r--) {}
                } else {
                    int abs = Math.abs(s - target);
                    if (abs < x) {
                        x = abs;
                        res = s;
                    }
                    for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
