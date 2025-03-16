package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 617. 合并二叉树
 *
 * 分解子问题：合并根节点，合并左子树，合并右子树，最后根节点连接左右子树。
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
