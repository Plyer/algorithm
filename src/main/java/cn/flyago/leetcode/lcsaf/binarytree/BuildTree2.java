package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, postorder, 0, inorder.length);
    }

    private TreeNode build(int[] inorder, int is, int[] postorder, int ps, int len) {
        if (len <= 0) {
            return null;
        }
        int x = postorder[ps + len - 1];
        TreeNode root = new TreeNode(x);
        int leftLen = 0;
        while (inorder[is + leftLen] != x) {
            leftLen++;
        }
        root.left = build(inorder, is, postorder, ps, leftLen);
        root.right = build(inorder, is + leftLen + 1, postorder, ps + leftLen, len - leftLen - 1);
        return root;
    }
}
