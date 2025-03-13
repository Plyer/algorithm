package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * <p>
 * 先递归右子树，然后递归左子树，这样能保证相同深度的节点一定先遇到最右边的节点。
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
}
