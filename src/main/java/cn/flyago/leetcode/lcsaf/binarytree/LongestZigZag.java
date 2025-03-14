package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1372. 二叉树中的最长交错路径
 *
 * 枚举：
 * 做法1：外部定义结果变量，递归函数中传递当前节点是左节点还是右节点以及祖先节点的交错路径节点数，如果当前节点和子节点的方向相同，子节点的交错路径节点数改为 1，否则加一继续往下传，当到达 null 节点时保存结果。
 * 做法2：外部保存长度，递归函数保存包括参数节点在内的交错路径长度。
 */
public class LongestZigZag {
    int res;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, 1, 1);
        dfs(root.right, 2, 1);
        return res;
    }

    private void dfs(TreeNode root, int direction, int cnt) {
        if (root == null) {
            res = Math.max(res, cnt - 1);
            return;
        }

        dfs(root.left, 1, direction == 1 ? 1 : cnt + 1);
        dfs(root.right, 2, direction == 2 ? 1 : cnt + 1);
    }

    public int longestZigZag2(TreeNode root) {
        dfs2(root, 1, 0);
        return res;
    }

    private void dfs2(TreeNode root, int direction, int len) {
        if (root == null) {
            res = Math.max(res, len);
            return;
        }

        dfs(root.left, 1, direction == 1 ? 1 : len + 1);
        dfs(root.right, 2, direction == 2 ? 1 : len + 1);
    }
}
