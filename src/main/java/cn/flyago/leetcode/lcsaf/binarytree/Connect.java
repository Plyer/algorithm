package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayDeque;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 层序遍历
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (i < len - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
