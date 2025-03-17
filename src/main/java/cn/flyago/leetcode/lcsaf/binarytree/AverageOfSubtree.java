package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 2265. 统计值等于子树平均值的节点数
 *
 * 递归函数返回三个值：子树和、子树节点数、统计值等于子树平均值的节点数。
 */
public class AverageOfSubtree {
    static final int[] ZERO = new int[]{0,0,0};
    public int averageOfSubtree(TreeNode root) {
        return f(root)[2];
    }

    private int[] f(TreeNode root) {
        if (root == null) {
            return ZERO;
        }
        int[] left = f(root.left);
        int[] right = f(root.right);
        int sum = left[0] + right[0] + root.val;
        int nodeCounts = left[1] + right[1] + 1;
        boolean curNodeVerify = sum / nodeCounts == root.val;
        int avgNodeCnts = curNodeVerify ? left[2] + right[2] + 1 : left[2] + right[2];
        return new int[]{sum , nodeCounts, avgNodeCnts};
    }
}
