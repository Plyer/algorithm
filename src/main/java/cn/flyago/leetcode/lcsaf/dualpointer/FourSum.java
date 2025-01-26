package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 枚举第一个数，后面的数组求三数之和。
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return res;
        }
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < n - 3; i++) {
            long cur = nums[i];
            if (i > 0 && cur == nums[i - 1]) continue;
            if ((sum = cur + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) break;
            if ((sum = cur + nums[n - 1] + nums[n - 2] + nums[n - 3]) < target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                int curj = nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if ((sum = cur + curj + nums[j + 1] + nums[j + 2]) > target) break;
                if ((sum = cur + curj + nums[n - 2] + nums[n - 1]) < target) continue;
                for (int l = j + 1, r = n - 1; l < r; ) {
                    sum = cur + curj + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList((int) cur, curj, nums[l], nums[r]));
                        for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                        for (r--; l < r && nums[r] == nums[r + 1]; r--) {}
                    } else if (target < sum) {
                        for (r--; l < r && nums[r] == nums[r + 1]; r--) {}
                    } else {
                        for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long s = (long)1000000000 + 1000000000 + 1000000000;
        System.out.println(s);
    }
}
