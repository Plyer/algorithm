package cn.flyago.leetcode.system;

import cn.flyago.leetcode.base.TreeNode;

import java.util.*;

/**
 * 102 二叉树的层序遍历
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        traverse(root, 0, map);
        return new ArrayList<>(map.values());
    }

    private void traverse(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        map.compute(level, (k, oldV) -> {
            if (oldV == null) {
                oldV = new ArrayList<>();
            }
            oldV.add(root.val);
            return oldV;
        });
        traverse(root.left, level + 1, map);
        traverse(root.right, level + 1, map);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Wapper> queue = new LinkedList<>();
        queue.offer(new Wapper(root, 0));
        Wapper w;

        while ((w = queue.poll()) != null) {
            if (w.node == null) {
                continue;
            }
            if (w.level >= res.size()) {
                res.add(new ArrayList<>());
            }
            List<Integer> levelList = res.get(w.level);
            levelList.add(w.node.val);
            queue.offer(new Wapper(w.node.left, w.level + 1));
            queue.offer(new Wapper(w.node.right, w.level + 1));
        }
        return res;
    }

    private static class Wapper {
        TreeNode node;
        int level;

        public Wapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
