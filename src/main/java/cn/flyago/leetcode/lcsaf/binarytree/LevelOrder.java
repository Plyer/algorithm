package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * 使用队列实现：根节点入队，获取队列的长度 len 表示当前层的长度，当 len>0 时循环：出队，并把值加入数组，把出队的左右节点加入队列。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> list = new ArrayDeque<>();
        list.addLast(root);

        List<List<Integer>> res = new ArrayList<>();
        for (int len = list.size(); len > 0; len = list.size()) {
            List<Integer> l = new ArrayList<>(len);
            res.add(l);
            for (int i = 0; i < len; i++) {
                TreeNode node = list.pollFirst();
                l.add(node.val);
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
        }
        return res;
    }
}
