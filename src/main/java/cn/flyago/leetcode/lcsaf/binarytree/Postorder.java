package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 */
public class Postorder {

    // 递归
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    // 用循环模拟递归
    public List<Integer> postorder2(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new LinkedList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }

    private void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child, list);
        }
        list.add(root.val);
    }
}
