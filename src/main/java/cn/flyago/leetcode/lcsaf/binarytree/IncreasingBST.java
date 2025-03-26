package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 897. 递增顺序搜索树
 *
 * 一边中序遍历一边构造树
 */
public class IncreasingBST {
    TreeNode dummy = new TreeNode(), p = dummy;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return dummy.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        p.right = new TreeNode(root.val);
        p = p.right;
        dfs(root.right);
    }
}
