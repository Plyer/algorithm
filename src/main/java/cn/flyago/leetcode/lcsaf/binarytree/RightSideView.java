package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * <p>
 * 先递归右子树，然后递归左子树，这样能保证相同深度的节点一定先遇到最右边的节点。
 * <p>
 * 层序遍历：记录每一层的最后一个值。
 */
public class RightSideView {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        f(root, -1);
        return res;
    }

    private void f(TreeNode root, int parentDeep) {
        if (root == null) {
            return;
        }
        if (++parentDeep == res.size()) {
            res.add(root.val);
        }
        f(root.left, parentDeep);
        f(root.right, parentDeep);
        if (res.size() > parentDeep) {
            res.set(parentDeep, root.val);
        }
    }

    // 灵神题解
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) { // 首次遇见这个深度
            res.add(root.val);
        }
        // 先递归右子树再递归左子树
        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }

    // 层序遍历
    public List<Integer> rightSideView3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int len = queue.size(); len > 0; len = queue.size()) {
            int val = 0;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                val = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(val);
        }
        return res;
    }

}
