package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {
    List<Integer> res = new ArrayList<>();

    // todo 迭代写法
    public List<Integer> inorderTraversal2(TreeNode root) {
        return null;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        f(root);
        return res;
    }

    private void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.left);
        res.add(root.val);
        f(root.right);
    }
}
