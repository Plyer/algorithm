package cn.flyago.leetcode.lcsaf.dualpointer;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 *
 * 相向双指针：数组升序排序，枚举第一个数 i，以 i 为三元组第一个元素的情况，在 i 后面的数组元素中使用两数之和的技巧找到 -i 即可找到三元组。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复值
            if (i >= n - 2 || nums[i] + nums[i + 1] + nums[i + 2] > 0) break; // 最小三元组都大于0，后面的元组都不符合要求
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue; // 最大三元组小于0，下一个。
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                } else if (sum > 0) {
                    for (r--; r > l && nums[r] == nums[r + 1]; r--) {}
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    for (l++; l < r && nums[l] == nums[l - 1]; l++) {}
                    for (r--; r > l && nums[r] == nums[r + 1]; r--) {}
                }
            }
        }
        return res;
    }
}
