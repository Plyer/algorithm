package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        List<Integer> res = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode pop = list.pop();
            res.add(pop.val);
            if (pop.right != null) list.push(pop.right);
            if (pop.left != null) list.push(pop.left);
        }
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        f(root, res);
        return res;
    }

    private void f(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        f(root.left, res);
        f(root.right, res);
    }
}
