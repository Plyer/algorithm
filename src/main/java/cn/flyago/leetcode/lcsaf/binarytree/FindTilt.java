package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 563. 二叉树的坡度
 *
 * 1. 二叉树的坡度等于左右子树的坡度和加上当前节点的坡度，求当前节点的坡度需要知道子树的和，关键在于求左右子树和的同时求出左右子树的坡度。
 * 2. 当节点为 Null 时坡度为 0， 子树和也为 0。
 * 3. 定义递归函数，返回两个值，一个坡度一个树的和。
 */
public class FindTilt {
    static final int[] zero = new int[]{0, 0};
    public int findTilt(TreeNode root) {
        return findTiltAndSum(root)[0];
    }

    private int[] findTiltAndSum(TreeNode root) {
        if (root == null) {
            return zero;
        }
        int[] left = findTiltAndSum(root.left);
        int[] right = findTiltAndSum(root.right);
        int tilt = Math.abs(left[1] - right[1]) + left[0] + right[0];
        int sum = left[1] + right[1] + root.val;
        return new int[]{tilt, sum};
    }
}
