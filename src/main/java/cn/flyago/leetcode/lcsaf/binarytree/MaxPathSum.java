package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 *
 * 类似 687 题。
 * 定义递归函数求以根节点为起点的最大路径和。求左子树节点为起点的最大路径和 l，以及右 r，路过根节点的最大路径和就是 Math.max(l,0)+Math.max(r,0)+root.val。简化一下，递归函数结果为负时返回0。
 */
public class MaxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + root.val);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
