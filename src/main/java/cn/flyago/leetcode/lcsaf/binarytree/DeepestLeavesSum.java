package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;

/**
 * 1302. 层数最深叶子节点的和
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int res = 0;
        for (int len = queue.size(); len > 0; len = queue.size()) {
            res = 0;
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                res += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return res;
    }
}
