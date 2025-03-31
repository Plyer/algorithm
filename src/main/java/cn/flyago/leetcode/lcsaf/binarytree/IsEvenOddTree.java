package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;

/**
 * 1609. 奇偶树
 */
public class IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        ArrayDeque<TreeNode> queue =new ArrayDeque<>();
        queue.addLast(root);
        for (int len = queue.size(), i = 0; len > 0; len = queue.size(), i++) {
            boolean even = (i & 1) == 0;
            int pre = even ? 0 : Integer.MAX_VALUE;
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                if (even && ((node.val & 1) == 0 || node.val <= pre)) {
                    return false;
                }
                if (!even && ((node.val & 1) == 1) || node.val >= pre) {
                    return false;
                }
                pre = node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
        }
        return true;
    }
}
