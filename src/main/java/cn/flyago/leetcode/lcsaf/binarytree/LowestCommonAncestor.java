package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 分解子问题：
 * 1. 自上而下 dfs 的过程中，如果遇到 p 或者 q 就直接返回当前节点不必往下遍历（反证法：如果遇到 p 且 q 不是 p 的子节点，那 q 一定会从其他遍历过程中返回，然后根据左右子树分别包括 p q 的情况返回 root 节点）。
 * 2. 如果当前节点值比 p 和 q 都大，那往左子树找；如果当前节点值比 p 和 q 都小，那往右子树找。否则当前节点值就是最近公共祖先。
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
