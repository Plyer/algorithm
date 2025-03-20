package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 687. 最长同值路径
 *
 * 分解子问题。当知道子树根节点开始到它的叶子过程中的最长同值路径时，比较根节点和子树值是否相同，如果相同那么直径就延长。
 * 定义递归函数求根节点开始到它的叶子过程中的最长同值路径，外部定义结果函数，在递归过程中求最大值。
 */
public class LongestUnivaluePath {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == root.right) {
            return 0;
        }
        int left = dfs(root.left);
        int r = 0; // 当前根节点到叶子节点的最大同值路径
        int x = 0; // 经过当前根节点的最大同值路径
        if (root.left != null && root.left.val == root.val) {
            r += left + 1;
            x += left + 1;
        }
        int right = dfs(root.right);
        if (root.right != null && root.right.val == root.val) {
            r = Math.max(r, right + 1);
            x += right + 1;
        }
        res = Math.max(res, x);
        return r;
    }
}
