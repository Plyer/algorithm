package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 44. 开幕式焰火
 *
 * 使用一个外部变量 Set 保存节点值，枚举完成后 Set 的大小就是结果。
 */
public class NumColor {
    public int numColor(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        f(root, set);
        return set.size();
    }

    private void f(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        f(root.left, set);
        f(root.right, set);
    }
}
