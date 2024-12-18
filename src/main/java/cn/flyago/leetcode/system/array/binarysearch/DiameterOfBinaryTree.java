package cn.flyago.leetcode.system.array.binarysearch;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 543. 二叉树的直径
 * 二叉树的直径等于以下三个值的最大值：左子树的直径、右子树的直径、左右子树深度和
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return help(root)[0];
    }

    // 获取二叉树的直径和最大深度
    int[] help(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = help(node.left);
        int[] right = help(node.right);
        int depth = Math.max(left[1], right[1]) + 1;
        int diameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);
        return new int[]{diameter, depth};
    }
}
