package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 *
 * 中序遍历二叉树，把当前节点值和上一个中序值比较，如果相同则增加计数，如果不同则重新计数，在这个过程中记录众数。
 */
public class FindMode {
    List<Integer> res = new ArrayList<>();
    int cnt, maxCnt, pre;
    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        cnt = pre == root.val ? cnt + 1 : 1;
        pre = root.val;
        if (cnt > maxCnt) {
            maxCnt = cnt;
            res = new ArrayList<>();
            res.add(root.val);
        } else if (cnt == maxCnt) {
            res.add(root.val);
        }
        dfs(root.right);
    }
}
