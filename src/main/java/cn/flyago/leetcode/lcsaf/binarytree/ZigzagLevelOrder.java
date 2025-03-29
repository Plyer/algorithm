package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * 层序遍历时记录层数，对偶数层的遍历进行反转后再加入结果
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean left2Right = true;
        for (int len = queue.size(); len > 0; len = queue.size()) {
            List<Integer> l = new ArrayList<>(len);
            res.add(l);
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pollFirst();
                l.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            if (!left2Right) {
                for (int le = 0, ri = l.size() - 1; le < ri; le++, ri--) {
                    int t = l.get(le);
                    l.set(le, l.get(ri));
                    l.set(ri, t);
                }
            }
            left2Right = !left2Right;
        }
        return res;
    }
}
