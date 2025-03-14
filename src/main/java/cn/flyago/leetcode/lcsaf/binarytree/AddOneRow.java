package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 623. 在二叉树中增加一行
 *
 * 枚举：在递归函数中增加当前深度，当深度到达 depth-1 时，增加一层节点。
 */
public class AddOneRow {
    int val, depth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        this.val = val;
        this.depth = depth;
        dfs(root, 1);
        return root;
    }

    private void dfs(TreeNode root, int curDepth) {
        if (root == null || curDepth >= depth) {
            return;
        }
        if (curDepth == depth - 1) { // 在 depth-1 的深度的所有节点下方增加一层
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        dfs(root.left, curDepth + 1);
        dfs(root.right, curDepth + 1);
    }

}
