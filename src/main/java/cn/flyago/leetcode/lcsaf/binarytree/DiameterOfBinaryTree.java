package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * 关注路径的转折点，以它为根节点，那就可以把整条路径分成三部分，左子树的最大高度减一、右子树的最大高度减一、根节点连接左右子树的两条边，这条路径就是路过当前转折点的最长直径，枚举所有转折点求出最大直径。
 */
public class DiameterOfBinaryTree {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right + 2, res);
        return Math.max(left, right) + 1;
    }
}
