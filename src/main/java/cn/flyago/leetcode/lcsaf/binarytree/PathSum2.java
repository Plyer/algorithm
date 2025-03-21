package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III
 *
 * 前缀和加哈希表。把根节点到叶节点的路径想象成一个数组，那这条路径中从上往下的所有和为 targetSum 的路径就是所有子数组和等于 targetSum 的路径，这可以用前缀和加哈希表求出，那就对根到每个叶子节点的路径使用上述算法求解。
 * 根节点途径的路径和可以使用回溯来传递。
 */
public class PathSum2 {
    int res;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sum2Cnt = new HashMap<>();
        sum2Cnt.put(0L, 1); // 前缀和初始化
        dfs(root, 0, sum2Cnt, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long sum, Map<Long, Integer> sum2Cnt, final int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        // 前缀和是 rightSum-leftSum=targetSum，那使用 rightSum-targetSum 就能找到需要的父节点前缀和，从哈希表得到数量
        res += sum2Cnt.getOrDefault(sum - targetSum, 0);
        sum2Cnt.merge(sum, 1, Integer::sum);

        dfs(root.left, sum, sum2Cnt, targetSum);
        dfs(root.right, sum, sum2Cnt, targetSum);
        sum2Cnt.merge(sum, -1, Integer::sum); // 从当前节点返回，那这个前缀和就要移除
    }

}
