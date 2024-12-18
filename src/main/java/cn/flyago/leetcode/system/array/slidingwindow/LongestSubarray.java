package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 *
 * 不定长滑动窗口算法：使用 boolean 确定窗口中是否仅包含一个 0，在滑动过程中保存满足条件的最大子数组长度。
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        boolean flag = false;
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (nums[r] == 0 && flag) {
                flag = nums[l] != 0;
                l++;
            }
            if (nums[r] == 0) {
                flag = true;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
