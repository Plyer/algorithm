package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;

/**
 * 2962. 统计最大元素出现至少 K 次的子数组
 * <p>
 * 不定长滑动窗口算法-越长越合法：先求出最大值 max，重新开始入窗并记录 max 的出现次数 c。
 * 1. 当 c==K 时缩减窗口，缩减完成后 res+=left。
 * 2. 当 c<k 时有两种情况，left=0 和 left>0 分别表示未满足和后续的已满足，所以也是 res+=left。
 */
public class CountSubarrays {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int c = 0;
        long res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == max) c++;
            while (c == k) {
                if (nums[l++] == max) c--;
            }
            res += l;
        }
        return res;
    }
}
