package cn.flyago.leetcode.lcsaf.slidingwindow;

/**
 * 1004. 最大连续1的个数 III
 *
 * 不定长滑动窗口算法：问题可以转换成求数组元素中至多有 K 个0的最长子串长度。
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int res = 0, sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (r - l + 1 - sum > k) {
                sum -= nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public int longestOnes2(int[] nums, int k) {
        int zeroCnt = 0, ans = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            zeroCnt += nums[r] ^ 1;
            while (zeroCnt > k) {
                zeroCnt -= nums[l++] ^ 1;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LongestOnes().longestOnes2(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }
}
