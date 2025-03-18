package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1110. 删点成林
 *
 * 外部维护结果变量，递归函数返回删除后的节点。
 * 1. 如果当前节点为空或者当前节点是叶子节点并且需要删除则返回 null。
 * 2. 对当前节点的左右子树进行递归删除并赋值回原来的左右子树。
 * 3. 如果当前节点需要删除，把不为空的左右子树加入结果。否则返回当前节点。
 */
public class DelNodes {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int[] freq = new int[1001];
        for (int i : to_delete) {
            freq[i]++;
        }
        TreeNode treeNode = delNodes2(root, freq);
        if (treeNode != null) res.add(treeNode);
        return res;
    }

    public TreeNode delNodes2(TreeNode root, int[] freq) {
        if (root == null) return null;
        if (root.left == root.right && freq[root.val] > 0) {
            return null;
        }
        root.left = delNodes2(root.left, freq);
        root.right = delNodes2(root.right, freq);
        if (freq[root.val] > 0) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}
