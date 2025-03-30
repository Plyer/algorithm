package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在层序遍历时判断左右子树的值，如果符合就保存其父节点，每遍历完一层判断一次结果。
 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<TreeNode> fathers = new ArrayList<>();
        for (int len = queue.size(); len > 0; len = queue.size()) {
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                    if (node.left.val == x || node.left.val == y) {
                        fathers.add(node);
                    }
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    if (node.right.val == x || node.right.val == y) {
                        fathers.add(node);
                    }
                }
                if (fathers.size() == 2) {
                    return fathers.get(0) != fathers.get(1);
                }
            }
            if (fathers.size() == 1) {
                return false;
            }
        }
        return false;
    }
}
