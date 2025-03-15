package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 951. 翻转等价二叉树
 *
 * 归：分解子问题，首先根节点值要相同，两棵树是翻转等价二叉树只要满足以下情况之一：
 * 1. 当 p 的左子树和 q 的右子树是翻转等价二叉树并且 p 的右子树和 q 的左子树是翻转等价二叉树。
 * 2. 当 p 的左子树和 q 的左子树是翻转等价二叉树并且 p 的右子树和 q 的右子树是翻转等价二叉树。
 */
public class FlipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.val != root2.val) {
            return false;
        }
        boolean scene1 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        if (scene1) {
            return true;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }
}
