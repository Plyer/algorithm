package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            long sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            res.add(sum / (double) len);
        }
        return res;
    }
}
