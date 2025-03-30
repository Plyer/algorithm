package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            int max = Integer.MIN_VALUE;
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                max = Math.max(max, node.val);
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
