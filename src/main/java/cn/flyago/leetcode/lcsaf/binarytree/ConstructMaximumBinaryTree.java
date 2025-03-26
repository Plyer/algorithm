package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 654. 最大二叉树
 *
 * // todo 单调栈优化
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if (s >= e) {
            return null;
        }
        int maxIdx = getMax(nums, s, e);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = constructMaximumBinaryTree(nums, s, maxIdx);
        root.right = constructMaximumBinaryTree(nums, maxIdx + 1, e);
        return root;
    }

    private int getMax(int[] arr, int s, int e) {
        int maxIdx = s;
        for (int i = s + 1; i < e; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
