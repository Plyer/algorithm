package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 */
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return build(list, 0, list.size());
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private TreeNode build(List<Integer> list, int s, int e) {
        if (s >= e) {
            return null;
        }
        int mid = s + (e - s) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, s, mid);
        root.right = build(list, mid + 1, e);
        return root;
    }
}
