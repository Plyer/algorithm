package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 404. 左叶子之和
 *
 * 既能使用枚举也能使用分解子问题的做法，但分解子问题更简单。
 * 分解子问题：求当前链表的左叶子之和就是左子树的左叶子和加上右子树的左叶子和，为了判断叶子是否为左叶子，在递归函数的参数增加一个标识。
 * 官方题解：dfs，当左节点是叶子时加到答案，否则把 dfs(root.left) 加到答案，当右节点不是叶子时把 dfs(root.right) 加到答案。
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return f(root.left, true) + f(root.right, false);
    }

    private int f(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return left ? root.val : 0;
        }
        return f(root.left, true) + f(root.right, false);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (isLeaf(root.left)) {
            res += root.left.val;
        } else {
            res += dfs(root.left);
        }
        if (!isLeaf(root.right)) {
            res += dfs(root.right);
        }
        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.right == null && node.left == null;
    }
}
