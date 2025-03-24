package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    int res = Integer.MAX_VALUE;
    int pre = -100000;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res = Math.min(res, root.val - pre);
        pre = root.val;
        dfs(root.right);
    }
}
