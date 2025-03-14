package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 *
 * 枚举：维护外部结果变量，在递归函数传递祖先节点组成的二进制数，当到达叶子节点时，把当前二进制数跟结果变量求和。
 * 分解子问题：从根到叶的二进制数之和就是从根到左右子树的叶的二进制数之和。同样在递归函数中传递祖先节点组成的二进制数，当遇到叶子节点时递归函数返回对应的二进制数之和。
 */
public class SumRootToLeaf {
    int res;

    // 枚举
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = (num << 1) + root.val;
        if (root.left == root.right) {
            res += num;
            return;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }

    // 分解子问题
    public int sumRootToLeaf2(TreeNode root) {
        return dfs2(root, 0);
    }

    private int dfs2(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = (num << 1) + root.val;
        if (root.left == root.right) {
            return num;
        }
        return dfs2(root.left, num) + dfs2(root.right, num);
    }
}
