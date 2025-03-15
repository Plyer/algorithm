package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 965. 单值二叉树
 *
 * 归：左右子树都是单值二叉树并且值和父节点都相等，那么整棵树就是单值二叉树。
 */
public class IsUnivalTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null || root.left == root.right) {
            return true;
        }
        boolean left = isUnivalTree(root.left);
        if (!left) {
            return false;
        }
        boolean right = isUnivalTree(root.right);
        if (!right) {
            return false;
        }

        if (root.left != null && root.right != null) {
            return root.val == root.left.val && root.val == root.right.val;
        } else if (root.left != null) {
            return root.val == root.left.val;
        } else {
            return root.val == root.right.val;
        }
    }
}
