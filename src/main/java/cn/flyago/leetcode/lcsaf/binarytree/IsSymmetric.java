package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 101. 对称二叉树
 *
 * 归：根节点无需检查，只要左右子树是否轴对称。对于判断两棵树是否轴对称，只要两棵树的根节点相同并且 a 树的左子树等于 b 树的右子树并且 a 树的右子树等于 b 树的左子树。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
