package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 *  1325. 删除给定值的叶子节点
 *
 *  定义函数返回剪枝后的树。
 *  1. 当前节点为 null 时返回 Null。
 *  2. 剪枝左右子树，如果当前节点变成叶子节点并且节点值等于 target 则返回 null，否则返回当前剪枝后的树。
 */
public class RemoveLeafNodes {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == root.right && root.val == target) {
            return null;
        }
        return root;
    }
}
