package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 根据节点属于左子树还是右子树分两种情况，根节点等同于右子树的情况。
 * 1. 如果一个节点是右子树，当前节点值更改为右子树的节点和加上当前节点值加上祖父节点的值（有点难描述，看代码）。
 * 2. 如果一个节点是左子树，从递归函数传入比当前值大的节点和即父节点的值，这个节点和加上当前节点值再加上右子树的节点和即为当前节点值。
 *
 * 递归函数返回节点和。
 */
public class ConvertBST {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        final int originalVal = root.val;
        int right = dfs(root.right, parentVal);
        root.val = root.val + parentVal + right;
        int left = dfs(root.left, root.val);
        return originalVal + left + right;
    }
}
