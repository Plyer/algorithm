package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 112. 路径总和
 *
 * 递：枚举，在外部维护结果，递归函数传入上级路径和和目标和，枚举过程中当遇到叶子节点时对比当前路径总和是否和目标相等。
 * 归：分解子问题，当前节点是否满足路径综合可以分解两种情况：
 *    1. 当前节点是叶子节点，当前节点值是否等于 targetSum。否则执行 2。
 *    2. 左右子树其一是否满足 targetSum-node.val 的路径总和。
 */
public class HasPathSum {
    boolean res;

    // 递
    public boolean hasPathSum(TreeNode root, int targetSum) {
        f(root, targetSum, 0);
        return res;
    }

    // 归
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (isLeaf(root)) {
            return root.val == targetSum;
        }

        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

    private void f(TreeNode root, int targetSum, int parentSum) {
        if (res || root == null) {
            return;
        } else if (isLeaf(root)) {
            if ((parentSum + root.val) == targetSum) {
                res = true;
            }
            return;
        }
        int sum = parentSum + root.val;
        f(root.left, targetSum, sum);
        f(root.right, targetSum, sum);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.right == null && node.left == null;
    }
}
