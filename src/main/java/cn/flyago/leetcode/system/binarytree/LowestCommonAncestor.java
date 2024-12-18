package cn.flyago.leetcode.system.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 *
 * 两种算法
 * - 使用回溯分别记录两个目标节点的祖先到两个数组，从前往后遍历两个数组直到数组元素不相等，最后一个相等的元素即为公共祖先。
 * - 使用分解问题的思路，如果当前节点是null则最近公共祖先为null，如果当前节点是p或q则最近公共最先就是当前节点，从左右子树去寻找最近公共祖先：如果左右子树都找到那么p和q分别位于左右子树，当前节点为最近公共祖先；如果左子树不为空，p和q都位于左子树，左子树的函数调用即为最近公共祖先，同理可得右子树；若都没找到返回Null，递归会继续在其他节点寻找。
 */
public class LowestCommonAncestor {

    private LinkedList<TreeNode> trace = new LinkedList<>();
    private List<TreeNode> ptrace = null;
    private List<TreeNode> qtrace = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root, p, q);
        int i = 0;
        for (; i < ptrace.size() && i < qtrace.size() && ptrace.get(i).val == qtrace.get(i).val; i++) {}
        return ptrace.get(--i);
    }

    void help(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || (ptrace != null && qtrace != null)) {
            return;
        }
        trace.add(root);
        if (root.val == p.val) {
            ptrace = new ArrayList<>(trace);
        }
        if (root.val == q.val) {
            qtrace = new ArrayList<>(trace);
        }

        help(root.left, p, q);
        help(root.right, p, q);
        trace.removeLast();
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
