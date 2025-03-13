package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 *
 * 递：枚举，在递归参数中记录根节点到父节点的最大值 parentMax，如果当前节点值大于等于 parentMax 则为好节点并更新 parentMax，否则不是好节点。
 */
public class GoodNodes {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(TreeNode root, int parentMax) {
        if (root == null) {
            return;
        }
        if (root.val >= parentMax) {
            res++;
            parentMax = root.val;
        }
        dfs(root.left, parentMax);
        dfs(root.right, parentMax);
    }
}
