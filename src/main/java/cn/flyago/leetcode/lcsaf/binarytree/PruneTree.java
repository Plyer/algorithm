package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 814. 二叉树剪枝
 *
 * 分解子问题：对左右子树进行剪枝，剪枝完之后如果根节点为 0 且左右子树都为空则返回 Null。
 *
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == root.right && root.val == 0) {
            return null;
        }
        return root;
    }
}
