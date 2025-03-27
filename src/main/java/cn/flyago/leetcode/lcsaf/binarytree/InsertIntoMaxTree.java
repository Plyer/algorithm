package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 998. 最大二叉树 II
 * <p>
 * 先还原成数组，然后再生成二叉树。
 * <p>
 * 题解做法：
 * 分两种情况：
 * 1. 如果新值是最大值，那新值就是根节点，原根节点作为新节点的左子树。
 * 2. 由于新值添加在末尾，所以它的待插入位置一定是某个节点的右子树：从根节点开始枚举，比较当前节点值和新值的大小，如果当前值小于新值，那么新值就符合第一种情况，可以插入当前节点。
 */
public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode pre = null, cur = root;
        while (cur != null && cur.val > val) {
            pre = cur;
            cur = cur.right;
        }
        TreeNode x = new TreeNode(val);
        if (pre == null) {
            x.left = root;
            return x;
        }
        pre.right = x;
        x.left = cur;
        return root;
    }

    public TreeNode insertIntoMaxTree2(TreeNode root, int val) {
        List<Integer> list = help(root);
        list.add(val);
        return gen(list, 0, list.size());
    }

    private TreeNode gen(List<Integer> list, int s, int e) {
        if (s >= e) {
            return null;
        }
        int maxIdx = getMaxIdx(list, s, e);
        TreeNode root = new TreeNode(list.get(maxIdx));
        root.left = gen(list, s, maxIdx);
        root.right = gen(list, maxIdx + 1, e);
        return root;
    }

    private int getMaxIdx(List<Integer> list, int s, int e) {
        int res = s;
        for (int i = s + 1; i < e; i++) {
            res = list.get(i) > list.get(res) ? i : res;
        }
        return res;
    }

    private List<Integer> help(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> left = help(root.left);
        List<Integer> res = left != null ? left : new ArrayList<>();
        res.add(root.val);
        List<Integer> right = help(root.right);
        if (right != null) res.addAll(right);
        return res;
    }
}
