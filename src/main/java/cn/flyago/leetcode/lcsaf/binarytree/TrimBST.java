package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 669. 修剪二叉搜索树
 *
 * 分解子问题，把二叉树分成三部分：根节点、左子树、右子树。递归修剪左子树和右子树，如果根节点在范围内则组合三部分，否则组合左右子树。
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (root.val >= low && root.val <= high) {
            root.left = left;
            root.right = right;
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        TreeNode pre = left, cur = left.right;
        while (cur != null) {
            pre = cur;
            cur = cur.right;
        }
        pre.right = right;
        return left;
    }
}
