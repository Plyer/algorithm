package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 111. 二叉树的最小深度
 * <p>
 * 递-自上而下传递参数：枚举过程中保存最大深度。
 * 归-自下而上传递参数：分解子问题，由子问题的解得出父问题的解。如果左右子树都存在，取左右子树最小深度加一，如果存在一个，取存在的最小深度加一，如果都不存在，深度为 1。
 */
public class MinDepth {
    int res = Integer.MAX_VALUE;

    // 递
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

    // 归
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return 1;
        }
        int l = minDepth2(root.left);
        int r = minDepth2(root.right);
        if (l != 0 && r != 0) {
            return Math.min(l, r) + 1;
        } else if (l != 0) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
