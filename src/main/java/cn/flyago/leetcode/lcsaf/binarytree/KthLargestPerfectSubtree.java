package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 3319. 第 K 大的完美二叉子树的大小
 *
 * 1. 当左右子树都是高度相同当前树就是完美二叉树。
 * 2. 递归函数返回高度，外部维护完美二叉树的高度，当左右子树高度相同时返回自身的高度并把高度添加到数组，否则返回 -1。
 * 3. 当 k 大于结果数组长度时返回 -1，否则排序后返回 arr[n-k]。
 */
public class KthLargestPerfectSubtree {
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getHeight(root, list);
        if (k > list.size()) {
            return -1;
        }
        Collections.sort(list);
        return (1 << list.get(list.size() - k)) - 1;
    }

    private int getHeight(TreeNode root, List<Integer> res) {
        if (root == null) {
            return 0;
        }
        // 注意左右子树都需要递归，不能因为其中一个返回 -1 就不递归另一个，如果不递归另一个会漏掉另一个子树的完美二叉树。
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        if (left == -1 || left != right) {
            return -1;
        }
        int height = left + 1;
        res.add(height);
        return height;
    }
}
