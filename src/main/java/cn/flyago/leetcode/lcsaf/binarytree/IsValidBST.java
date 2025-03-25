package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
