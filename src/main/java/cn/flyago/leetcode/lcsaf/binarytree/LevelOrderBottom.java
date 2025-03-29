package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层序遍历 II
 *
 * 正常进行层序遍历，但把结果使用链表保存到头部。
 *
 * 另一种做法，正常层序遍历，对结果做反转。
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            List<Integer> l = new ArrayList<>(len);
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                l.add(node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            res.addFirst(l);
        }
        return res;
    }
}
