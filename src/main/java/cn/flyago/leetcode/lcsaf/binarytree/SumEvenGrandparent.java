package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1315. 祖父节点值为偶数的节点和
 *
 * 递：祖父节点值为偶数的节点和是左子树的对应和加上右子树的对应和，如果当前节点的祖父为偶数，还要加上当前节点值。递归函数中传入祖父节点值和父节点值。
 */
public class SumEvenGrandparent {
    public int sumEvenGrandparent(TreeNode root) {
        int fatherNodeVal = 0, grandFatherNodeVal = 0;
        return dfs(root, fatherNodeVal, grandFatherNodeVal);
    }

    private int dfs(TreeNode root, int fatherNodeVal, int grandFatherNodeVal) {
        if (root == null) {
            return 0;
        }
        int sum = dfs(root.left, root.val, fatherNodeVal) + dfs(root.right, root.val, fatherNodeVal);
        if (grandFatherNodeVal != 0 && grandFatherNodeVal % 2 == 0) {
            sum += root.val;
        }
        return sum;
    }
}
