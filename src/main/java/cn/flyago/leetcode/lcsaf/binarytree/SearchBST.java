package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
