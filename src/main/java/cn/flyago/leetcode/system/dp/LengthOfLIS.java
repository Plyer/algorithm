package cn.flyago.leetcode.system.dp;

/**
 * 300 最长递增子序列
 *
 * 1. 明确状态：nums 数组
 * 2. 明确选择：nums[0..i] 的最长递增子序列等于 nums[0]..nums[0..i-1] 中小于 nums[i] 值的最长子序列+1
 * 3. dp 函数：len = dp(nums)，求 nums 数组的最长递增子序列长度。
 * 4. base case：如果 nums.len=1, dp(nums)=nums[0]
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length + 1];
        return dp(nums, nums.length - 1, memo);
    }

    private int dp(int[] nums, int e, int[] memo) {
        if (e == 0) {
            return 1;
        }

        int res = 1;
        for (int i = 0; i < e; i++) {
            int subLen = memo[i] == 0 ? dp(nums, i, memo) : memo[i];
            if (nums[e] > nums[i]) {
                res = Math.max(res, subLen + 1);
            }
        }
        memo[e] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}
