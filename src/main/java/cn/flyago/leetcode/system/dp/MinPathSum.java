package cn.flyago.leetcode.system.dp;

/**
 * 64 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 状态：不同 m x n 的网格
 * 选择：grid 的最小路径和等于下面两种场景中的较小值：
 *      1. grid[0][0] + grid[1][0]->grid[m-1][n-1]的最小路径和
 *      2. grid[0][0] + grid[0][1]->grid[m-1][n-1]的最小路径和
 * dp 数组：dp[i][j] 保存以 grid[i][j]->grid[m-1][n-1]
 * base case：dp[m-1]和dp[0..m-1][n-1]是以grid[m-1][n-1]为起点的前缀和
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        // base case
        dp[row-1][col-1] = grid[row-1][col-1];
        for (int i = col - 2; i >= 0; i--) {
            dp[row-1][i] = dp[row-1][i+1] + grid[row-1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col-1] = dp[i+1][col-1] + grid[i][col-1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.min(grid[i][j] + dp[i+1][j], grid[i][j] + dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
}
