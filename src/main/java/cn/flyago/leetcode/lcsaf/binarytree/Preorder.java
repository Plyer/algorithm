package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // 使用栈模拟递归
    public List<Integer> preorder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            int size = node.children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }


    private void dfs(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node child : node.children) {
            dfs(child, list);
        }
    }
}
