package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * 使用枚举的做法，定义两个变量 fi=0 se=0，枚举过程中更新这两个变量。
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        int[] res = new int[] {-1, -1};
        f(root, res);
        return res[1];
    }

    private void f(TreeNode root, int[] res) {
        if (root == null) {
            return;
        }
        if (res[0] == -1 || root.val < res[0]) {
            res[1] = res[0];
            res[0] = root.val;
        } else if (res[0] != root.val && (res[1] == -1 || root.val < res[1])) {
            // 注意：res[0] != root.val 用于防止最小值重复，这样只有不同的值才能赋值过来。
            res[1] = root.val;
        }
        f(root.left, res);
        f(root.right, res);
    }
}
