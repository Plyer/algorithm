package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 *
 * 分解子问题：
 * 当前节点为空时返回""，否则获取左右子树的字符串，分以下情况：
 * 1. 如果左边和右边都为""，直接返回根节点的值为字符串。
 * 2. 如果右边不为""，左右字符串都拼接上。
 * 3. 如果右边为""，仅拼接左字符串。
 */
public class Tree2str {
    static final String EMPTY = "";
    public String tree2str(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }
        String res = String.valueOf(root.val);
        if (root.left == root.right) {
            return res;
        }
        String left = tree2str(root.left);
        if (root.right != null) {
            res = String.format("%s(%s)(%s)", res, left, tree2str(root.right));
        } else {
            res = String.format("%s(%s)", res, left);
        }
        return res;
    }
}
