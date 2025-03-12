package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * 递：枚举方法，维护外部结果变量 res，递归函数增加一个上级深度，在递的过程中保存深度最大值。
 * 归：分解子问题，二叉树的最大深度就是左右子树深度较大值加一。
 */
public class MaxDepth {
    int res = 0;

    // 递
    public int maxDepth(TreeNode root) {
        f(root, 0);
        return res;
    }

    private void f(TreeNode root, int deep) {
        if (root == null) {
            res = Math.max(res, deep);
            return;
        }
        f(root.left, deep + 1);
        f(root.right, deep + 1);
    }

    // 归
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }
}