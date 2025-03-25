package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 *
 * 保存中序遍历结果，对结果排序，重新中序遍历二叉树对节点按排序后的数组赋值。
 *
 * 优化：保存中序遍历结果，从结果中找到两个需要交换的值，交换完成后恢复。
 *      其中寻找两个需要交换的值的算法是：当相邻的两个值是递减时找到第一组数组，这一组的第一个值是待交换值；当再次遇见递减数据，第二个值就是待交换值。
 *                                   使用双指针算法，比较 i 和 i+1，当 arr[i]<arr[i+1] 时保存 y=arr[i+1]、if(x==null) x=arr[i]，这样做 y 一定会被后续第二组的第二个值覆盖，而 x 一定是第一组的第一个值。
 *
 * 再次优化：中序遍历二叉树时使用 pre 保存前值，依然是判断到递减时寻找出待交换值，这样不必使用数组来保存。
 */
public class RecoverTree {
    int i;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Collections.sort(list);
        recover(root, list);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private void recover(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recover(root.left, list);
        root.val = list.get(i++);
        recover(root.right, list);
    }

    private void dfs2(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        dfs2(root.left, list);
        list.add(root);
        dfs2(root.right, list);
    }

    public void recoverTree2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs2(root, list);
        TreeNode x = null;
        TreeNode y = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                y = list.get(i + 1);
                if (x == null) {
                    x = list.get(i);
                }
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }
}
