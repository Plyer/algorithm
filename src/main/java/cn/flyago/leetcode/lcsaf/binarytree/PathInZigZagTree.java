package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 1104. 二叉树寻路
 *
 * 构造二叉树，然后 DFS 寻路。
 */
public class PathInZigZagTree {
    List<Integer> res = new ArrayList<>();
    public List<Integer> pathInZigZagTree(int label) {
        TreeNode root = levelBuild(label);
        dfs(root, new ArrayList<>(), label);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> l, int label) {
        if (root == null) {
            return;
        }
        l.add(root.val);
        if (label == root.val) {
            res = new ArrayList<>(l);
            return;
        }
        dfs(root.left, l, label);
        dfs(root.right, l, label);
        l.removeLast();
    }

    private TreeNode levelBuild(int label) {
        TreeNode root = new TreeNode(1);
        ArrayDeque<TreeNode> a = new ArrayDeque<>();
        a.add(root);
        ArrayDeque<TreeNode> b;
        boolean flag = true;
        int k = 1;
        out:
        while (true) {
            b = new ArrayDeque<>(a.size() * 2);
            if (flag) {
                while (!a.isEmpty()) {
                    TreeNode node = a.removeLast();
                    node.right = new TreeNode(++k);
                    node.left = new TreeNode(++k);
                    if (k >= label) {
                        break out;
                    }
                    b.addFirst(node.right);
                    b.addFirst(node.left);
                }
            } else {
                for (TreeNode node : a) {
                    node.left = new TreeNode(++k);
                    node.right = new TreeNode(++k);
                    if (k >= label) {
                        break out;
                    }
                    b.add(node.left);
                    b.add(node.right);
                }
            }
            a = b;
        }
        return root;
    }
}
