package cn.flyago.leetcode.system;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 129 求根节点到叶节点数字之和
 *
 * 根节点到叶子节点的和即为所有叶子节点的和，拆分成子问题即是(root.val * 10)作为基础加上后续节点的值。
 *
 * 除了拆分子问题的理解，更简单的理解是深度优先搜索：遍历到每个叶子节点，求和。
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }

        preSum = preSum * 10 + root.val;
        // 如果是叶子节点，return 计算值
        if (root.left == null && root.right == null) {
            return preSum;
        } else {
            // 非叶子节点，继续计算左右子树的值
            return dfs(root.left, preSum) + dfs(root.right, preSum);
        }
    }
}
