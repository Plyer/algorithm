package cn.flyago.leetcode.system.bfs;

import cn.flyago.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 111 二叉树的最小深度
 * 用层序遍历发现叶子节点的当前深度即为二叉树最小深度
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0, depthSize = 1;
        while (!queue.isEmpty()) {
            depth++;
            for (int i = 0; i < depthSize; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            depthSize = queue.size();
        }
        return depth;
    }
}
