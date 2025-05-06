package cn.flyago.leetcode.lcsaf.binarytree;

/**
 * 1863. 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {

    int sum, res;

    public int subsetXORSum(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res += sum;
            return;
        }
        dfs(i + 1, nums);
        sum ^= nums[i];
        dfs(i + 1, nums);
        sum ^= nums[i];
    }
}
