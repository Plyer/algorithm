package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 2331. 计算布尔二叉树的值
 */
public class EvaluateTree {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == root.right) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left || right : left && right;
    }
}
