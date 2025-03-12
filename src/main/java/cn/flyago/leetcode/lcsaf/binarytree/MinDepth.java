package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 */
public class MinDepth {
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        f(root, 0);
        return res;
    }

    private void f(TreeNode root, int deep) {
        if (deep == res) {
            return;
        }
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            res = Math.min(deep + 1, res);
            return;
        }
        f(root.left, deep + 1);
        f(root.right, deep + 1);
    }
}
