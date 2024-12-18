package cn.flyago.leetcode.system;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 98 验证二叉搜索树
 *
 * 中序遍历二叉搜索树的结果是一个递增序列，在遍历过程中判断结果是否符合递增即可。
 */
public class IsValidBST {

    private Integer last;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean validBST = isValidBST(root.left);
        if (!validBST) {
            return false;
        }
        if (last != null && root.val <= last) {
            return false;
        }
        last = root.val;
        return isValidBST(root.right);
    }
}
