package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 *
 * 中序遍历两棵树保存到数组，合并两个有序数组。
 */
public class GetAllElements {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return merge(list1, list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>(list1.size() + list2.size());
        for (int p1 = 0, p2 = 0; p1 < list1.size() || p2 < list2.size(); ) {
            if (p1 == list1.size()) {
                res.add(list2.get(p2++));
                continue;
            }
            if (p2 == list2.size()) {
                res.add(list1.get(p1++));
                continue;
            }
            Integer x = list1.get(p1);
            Integer y = list2.get(p2);
            if (x < y) {
                res.add(x);
                p1++;
            } else {
                res.add(y);
                p2++;
            }
        }
        return res;
    }
}
