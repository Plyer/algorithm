package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2641. 二叉树的堂兄弟节点 II
 *
 * 使用滚动数组层序遍历。
 */
public class ReplaceValueInTree {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>(), next;
        cur.add(root);
        cur.add(null);
        int sum = root.val, nextSum;
        while (!cur.isEmpty()) {
            next = new ArrayList<>();
            nextSum = 0;
            for (int i = 0; i < cur.size(); i+= 2) {
                TreeNode left = cur.get(i);
                TreeNode right = cur.get(i + 1);
                final int leftVal = left == null ? 0 : left.val;
                final int rightVal = right == null ? 0 : right.val;
                nextSum += getNextSum(next, sum, left, rightVal);
                nextSum += getNextSum(next, sum, right, leftVal);
            }
            sum = nextSum;
            cur = next;
        }
        return root;
    }

    private int getNextSum(List<TreeNode> next, int sum, TreeNode one, int anotherVal) {
        int nextSum = 0;
        if (one != null) {
            one.val = sum - one.val - anotherVal;
            if (one.left != null || one.right != null) {
                next.add(one.left);
                nextSum += one.left != null ? one.left.val : 0;
                next.add(one.right);
                nextSum += one.right != null ? one.right.val : 0;
            }
        }
        return nextSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(9));
        new ReplaceValueInTree().replaceValueInTree(root);
    }
}
