package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 *
 * 层序遍历还原，并把元素值保存到 Set。
 */
public class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b;
        a.add(root);
        root.val = 0;
        set.add(0);
        while (!a.isEmpty()) {
            b = new ArrayList<>();
            for (TreeNode node : a) {
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    set.add(node.left.val);
                    b.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    set.add(node.right.val);
                    b.add(node.right);
                }
            }
            a = b;
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
