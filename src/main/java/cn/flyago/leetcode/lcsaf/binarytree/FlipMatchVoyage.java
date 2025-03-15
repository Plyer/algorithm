package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 *
 * 枚举：
 * 1. 外部维护一个索引表示当前节点对应的先序遍历的索引 i，另外维护一个结果列表 res。
 * 2. 先序遍历二叉树，比较当前节点值和对应索引值是否一致，如果不一致则无法匹配。
 * 3. 比较当前节点的左右节点值是否能和 i+1 匹配，如果不能则无法匹配，如果右节点匹配就翻转链表并记录结果。
 */
public class FlipMatchVoyage {
    int i;
    List<Integer> res = new ArrayList<>();
    boolean end;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        return res;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (end || root == null) {
            return;
        }
        final int curIdx = i;
        i++;
        if (root.val != voyage[curIdx]) {
            res = new ArrayList<>();
            res.add(-1);
            end = true;
            return;
        }
        if (root.left == root.right) {
            return;
        }

        if (curIdx + 1 < voyage.length) {
            int left = root.left == null ? 0 : root.left.val;
            int right = root.right == null ? 0 : root.right.val;
            if (left != voyage[curIdx + 1] && right != voyage[curIdx + 1]) {
                res = new ArrayList<>();
                res.add(-1);
                end = true;
                return;
            }
            if (root.left != null && right == voyage[curIdx + 1]) {
                res.add(root.val);
                TreeNode t = root.left;
                root.left = root.right;
                root.right = t;
            }
        }

        dfs(root.left, voyage);
        dfs(root.right, voyage);
    }

    public static void main(String[] args) {
        new FlipMatchVoyage().flipMatchVoyage(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new int[]{1, 3, 2});
    }
}
