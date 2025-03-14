package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 *
 * 递：枚举，结果就是当前节点与其祖先的最大差值、左子树与其祖先的最大差值、右子树与其祖先的最大差值，三个值的最大值。
 *     递归函数传递祖先节点值的最大值 max 和最小值 min，那么当前节点与祖先节点的最大差值就是 max(abs(max-cur), abs(min-cur))。
 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }
        int a = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        min = Math.min(min ,root.val);
        max = Math.max(max, root.val);
        return Math.max(a, Math.max(dfs(root.left, min, max), dfs(root.right, min, max)));
    }
}
