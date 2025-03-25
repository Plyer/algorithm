package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 230. 二叉搜索树中第 K 小的元素
 */
public class KthSmallest {
    int cnt, res = -1;
    int k;

    public int kthSmallest(TreeNode root, int k) {
//        dfs(root, k);
//        return res;
        this.k = k;
        return dfs2(root);
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        if (++cnt == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public int dfs2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = dfs2(root.left);
        if (left != -1) return left;
        if (--k == 0) return root.val;
        return dfs2(root.right);
    }
}
