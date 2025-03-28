package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * 比较 val 和节点值的大小，如果 val>node.val 往右移动，否则往左移动，直到走到空节点，这个位置就是需要插入的位置。
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pre = null, cur = root;
        boolean isLeft = false;
        while (cur != null) {
            pre = cur;
            if (val > cur.val) {
                cur = cur.right;
                isLeft = false;
            } else {
                cur = cur.left;
                isLeft = true;
            }
        }
        if (isLeft) {
            pre.left = new TreeNode(val);
        } else {
            pre.right = new TreeNode(val);
        }
        return root;
    }
}
