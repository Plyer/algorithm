package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 找到数组的中间索引作为根节点，左边部分递归生成左子树，右边部分递归生成右子树。
 * 注意：如果中间索引有两个，要取大的那个。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s < e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, s, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, e);
        return root;
    }
}
