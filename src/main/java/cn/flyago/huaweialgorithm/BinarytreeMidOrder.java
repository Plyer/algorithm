package cn.flyago.huaweialgorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉树中序遍历输出 https://www.codeleading.com/article/43985735740/
 */
public class BinarytreeMidOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(midOrder(getTree(sc.nextLine(), 0).tree));
        }
    }

    static Box getTree(String s, int startIndex) {
        TreeNode root = new TreeNode(s.charAt(startIndex));
        if (s.charAt(startIndex + 1) != '{') {
            return new Box(root, startIndex);
        }

        List<TreeNode> child = new ArrayList<>();
        int i = startIndex + 2;
        for (; i < s.length() && s.charAt(i) != '}'; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                Box box = getTree(s, i);
                child.add(box.tree);
                i = box.end;
                continue;
            }
            // 大括号之后第一个字符是逗号，表示左节点为空
            if (c == ',' && i == startIndex + 2) {
                child.add(null);
            }
        }
        root.left = child.get(0);
        if (child.size() > 1) {
            root.right = child.get(1);
        }
        return new Box(root, i);
    }

    static String midOrder(TreeNode root) {
        if (root == null) {
            return "";
        }
        return midOrder(root.left) + root.val + midOrder(root.right);
    }

    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(char val) { this.val = val; }
        public TreeNode(char val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Data
    @AllArgsConstructor
    public static class Box {
        TreeNode tree;
        int end;
    }
}
