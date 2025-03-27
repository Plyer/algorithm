package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import javax.swing.plaf.basic.BasicGraphicsUtils;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode build(int[] preorder, int ps, int[] inorder, int is, int len) {
        if (len <= 0) {
            return null;
        }
        int x = preorder[ps];
        TreeNode root = new TreeNode(x);
        int p = is;
        while (inorder[p] != x) {
            p++;
        }
        int leftTreeLen = p - is;
        root.left = build(preorder, ps + 1, inorder, is, leftTreeLen);
        root.right = build(preorder, ps + 1 + leftTreeLen, inorder, p + 1, len - 1 - leftTreeLen);
        return root;
    }
}
