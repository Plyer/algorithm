package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;

/**
 * 513. 找树左下角的值
 * 从右往左层序遍历的最后一个值就是左下角的值。
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int res = 0;
        for (int len = queue.size(); len > 0; len = queue.size()) {
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                res = node.val;
                if (node.right != null) queue.addLast(node.right);
                if (node.left != null) queue.addLast(node.left);
            }
        }
        return res;
    }
}
