package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1339. 分裂二叉树的最大乘积
 *
 * 先求整颗树的节点和，遍历每个节点求以当前节点为根的节点和，(allSum-sum)*sum 就是分裂当前这颗树的情况，遍历完成之后得到结果。注意值很大要用 Long 保存，最后取余。
 *
 * 官方题解：
 */
public class MaxProduct {
    long res, allSum;
    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        sum(root);
        return (int) (res % 1000000007);
    }

    private long sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == root.right) {
            return root.val;
        }
        long left = sum(root.left);
        long right = sum(root.right);
        res = Math.max(res, Math.max(left * (allSum - left), right * (allSum - right)));
        return left + right + root.val;
    }

    private long sum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long sum = root.val + sum2(root.left) + sum2(root.right);
        res = Math.max(res, sum * (allSum - sum));
        return sum;
    }
}
