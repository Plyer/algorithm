package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * 判断平衡二叉树需要拿到左右子树的高度，而树的高度等于左右子树高度的较大值加一，在求树高度的函数中我们就已经拿到左右子树的高度，就可以同时判断当前这棵树是不是平衡二叉树，如果是那就返回当前树的高度，不是就返回 -1。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeight(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return  -1;
        }
        return Math.max(left, right) + 1;
    }
}
