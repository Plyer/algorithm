package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 865. 具有所有最深节点的最小子树
 *
 * 定义递归函数返回树的深度和具有最深节点的子树。递归过程中判断左右子树的深度，如果深度相同表示子树都包含最深节点返回当前节点，否则返回深度更深的子树对应的最小子树。
 */
public class SubtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }
        if (left.depth < right.depth) {
            return new Pair(right.node, right.depth + 1);
        }
        return new Pair(root, left.depth + 1);
    }

    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
