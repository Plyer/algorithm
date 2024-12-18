package cn.flyago.leetcode.system;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    private List<Integer> list = new ArrayList<>();
    private int i = 0;

    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    public int next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i >= 0 && i < list.size();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
