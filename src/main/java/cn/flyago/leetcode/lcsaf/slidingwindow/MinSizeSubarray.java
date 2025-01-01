package cn.flyago.leetcode.lcsaf.slidingwindow;

import java.util.Arrays;

/**
 * 2875. 无限数组的最短子数组
 *
 * 不定长滑动窗口算法：分两种情况
 * 1. 如果 target>arrSum，问题可以转换为求和为 target%arrSum 的最小子数组 minLen，结果为 minLen+target/arrSum*n。
 * 2. 如果 target<arrSum，问题可以转换为在长度为 2n 的数组中求和为 target 的最短子数组。
 * 3. 上述两种情况合并到一块，在长度为 2n 的数组中求和为 target%arrSum 的最短子数组 minLen，结果为 minLen+target/arrSum*n。
 */
public class MinSizeSubarray {
    public int minSizeSubarray(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (target == sum) {
            return n;
        }

        int windowSum = 0;
        int minLen = n + 1;
        for (int r = 0, l = 0; r < 2 * n; r++) {
            windowSum += nums[r % n];
            while (windowSum - nums[l % n] >= target % sum) {
                windowSum -= nums[l % n];
                l++;
            }
            if (windowSum == target) {
                minLen = Math.min(minLen, r - l + 1);
            }
        }

        return minLen <= n ? minLen + target / sum * n : -1;
    }
}
