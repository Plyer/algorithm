package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 */
public class PostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        f(root);
        return res;
    }

    private void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.left);
        f(root.right);
        res.add(root.val);
    }
}
