package cn.flyago.leetcode.system.dp;

/**
 * 198 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 状态：从索引 0 开始的不同长度的 nums
 * 选择：把 nums 分成两部分 nums[0..n-1] 和 nums[n]，nums[0..n]最高金额等于 max(nums[0..n-2] 的最高金额+nums[n], nums[0..n-1]最大金额)
 * dp 数组：dp[i] 保存 nums[0..i] 最大金额。（可优化成两个变量保存 n-1 和 n-2 的值）
 * base case: dp[0]=nums[0],dp[1]=max(nums[0],nums[1])
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int dp_i_2 = nums[0];
        int dp_i_1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int dp_i = Math.max(dp_i_2 + nums[i], dp_i_1);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
