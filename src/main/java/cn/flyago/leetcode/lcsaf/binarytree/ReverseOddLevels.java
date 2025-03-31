package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 2415. 反转二叉树的奇数层
 * <p>
 * 层序遍历：当下一层是需要反转的节点，保存反转那一层的值到数组，当到达反转层时，一边遍历一边修改节点值。
 */
public class ReverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<Integer> vals = null;
        for (int len = queue.size(), i = 0; len > 0; len = queue.size(), i++) {
            boolean even = (i & 1) == 0;
            if (even) vals = new ArrayList<>(len * 2);
            for (int j = 0; j < len; j++) {
                TreeNode node = queue.pollFirst();
                if (!even) { // 奇数层则反转值
                    node.val = vals.get(len - 1 - j);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                    if (even) vals.add(node.left.val);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    if (even) vals.add(node.right.val);
                }
            }
        }
        return root;
    }
}
