package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            List<Integer> l = new ArrayList<>(len);
            while (len-- > 0) {
                Node node = queue.pop();
                l.add(node.val);
                queue.addAll(node.children);
            }
            res.add(l);
        }
        return res;
    }
}
