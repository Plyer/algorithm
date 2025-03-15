package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 100. 相同的树
 *
 * 归：根节点相同并且左右子树分别相同。
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q; // 如果两个都是 Null 则相同，如果只有一个为 Null 则不同。
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
