package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 回溯：进入节点把当前节点值加到 sum 且把路径加上当前节点，离开节点把 sum-node.val 且把路径移除当前节点。
 */
public class PathSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == root.right) {
            if (sum + root.val == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            dfs(root.left, sum + root.val);
            dfs(root.right, sum + root.val);
        }
        path.removeLast();
    }
}
