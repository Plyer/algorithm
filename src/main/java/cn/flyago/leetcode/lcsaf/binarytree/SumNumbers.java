package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 *
 * 递：枚举，定义外部变量保存结果，递归函数传递上级节点的数字，当枚举到叶子节点时把当前数字加到结果上。
 */
public class SumNumbers {
    int res;
    public int sumNumbers(TreeNode root) {
        f(root, 0);
        return res;
    }

    private void f(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res += num * 10 + root.val;
            return;
        }
        num = num * 10 + root.val;
        f(root.left, num);
        f(root.right, num);
    }

}
