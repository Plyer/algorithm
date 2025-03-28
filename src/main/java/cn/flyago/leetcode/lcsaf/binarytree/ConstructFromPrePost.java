package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 889. 根据前序和后序遍历构造二叉树
 *
 * 前序的第二个值 sec 是左子树或者右子树的根节点值，分情况讨论：
 * 1. 如果 sec 在后序的倒数第二个值，那么有两种情况：右子树不存在或者左子树不存在。当前算法使用“右子树不存在”的情况。
 * 2. 如果 sec 在后续的倒数第二个值之前，那么就可以遍历找到右子树的长度。
 */
public class ConstructFromPrePost {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, postorder, 0, postorder.length);
    }

    private TreeNode build(int[] preorder, int prs, int[] postorder, int pos, int len) {
        if (len <= 0) {
            return null;
        }
        int x = preorder[prs];
        TreeNode root = new TreeNode(x);
        if (len == 1) {
            return root;
        }
        int sec = preorder[prs + 1];
        int k = len - 2;
        while (postorder[pos + k] != sec) {
            k--;
        }
        int rightLen = len - k - 2;
        root.left = build(preorder, prs + 1, postorder, pos, k + 1);
        root.right = build(preorder, prs + k + 2, postorder, pos + k + 1, rightLen);
        return root;
    }
}
