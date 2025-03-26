package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2476. 二叉搜索树最近节点查询
 * <p>
 * 中序遍历二叉树保存到数组，对这个数组使用二分算法求接近值。由于二叉搜索树所有值不同，因此只需要一次二分查找 >=t 的值 max，<=t 的值要么等于 max 要么等于 max 所在索引前面的值。
 */
public class ClosestNodes {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        List<List<Integer>> res = new ArrayList<>(queries.size());
        for (Integer query : queries) {
            int p = search(list, query);
            int max = p == list.size() ? -1 : list.get(p);
            if (max != query) p--;
            int min = p == -1 ? -1 : list.get(p);
            res.add(Arrays.asList(min, max));
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private int search(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
