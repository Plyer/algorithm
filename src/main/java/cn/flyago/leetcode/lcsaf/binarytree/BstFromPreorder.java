package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1008. 前序遍历构造二叉搜索树
 */
public class BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }

    private TreeNode bstFromPreorder(int[] preorder, int s, int e) {
        if (s >= e) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[s]);
        int i = s + 1;
        while (i < e && preorder[i] < preorder[s]) i++;
        root.left = bstFromPreorder(preorder, s + 1, i);
        root.right = bstFromPreorder(preorder, i, e);
        return root;
    }
}
