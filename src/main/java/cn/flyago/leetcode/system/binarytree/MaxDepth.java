package cn.flyago.leetcode.system.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
