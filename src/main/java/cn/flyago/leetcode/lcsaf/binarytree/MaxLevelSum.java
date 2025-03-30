package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;

/**
 * 1161. 最大层内元素和
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int res = 1, max = Integer.MIN_VALUE;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        for (int len = queue.size(), i = 1; len > 0; len = queue.size(), i++) {
            int sum = 0;
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            if (sum > max) {
                max = sum;
                res = i;
            }
        }
        return res;
    }
}
