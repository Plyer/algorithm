package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 */
public class RangeSumBST {

    // 当根节点大于 high 时，往左子树求和。
    // 当根节点小于 low 时，往右子树求和。
    // 当根节点在范围内时，当前值加上左右子树的范围和。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        if (x > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (x < low) {
            return rangeSumBST(root.right, low, high);
        }
        return x + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    // 首先判断根节点是否在范围内，在则加上根节点的值。
    // 如果根节点的值大于 low，那左子树可能有范围内的值，递归左子树求和。
    // 如果根节点的值小于 high，那右子树可能有范围内的值，递归右子树求和。
    // 对上述三个值求和就是整棵树的范围和。
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int x = root.val;
        int sum = x <= high && x >= low ? x : 0;
        if (x > low) {
            sum += rangeSumBST2(root.left, low, high);
        }
        if (x < high) {
            sum += rangeSumBST2(root.right, low, high);
        }
        return sum;
    }

}
