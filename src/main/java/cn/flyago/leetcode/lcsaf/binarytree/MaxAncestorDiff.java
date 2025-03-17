package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 *
 * 递：枚举，结果就是当前节点与其祖先的最大差值、左子树与其祖先的最大差值、右子树与其祖先的最大差值，三个值的最大值。
 *     递归函数传递祖先节点值的最大值 max 和最小值 min，那么当前节点与祖先节点的最大差值就是 max(abs(max-cur), abs(min-cur))。
 *
 * 归：分解子问题。分别得到左右子树的最大值和最小值，组合成一个的最大最小值，与根节点值比较就可得出以当前根节点为祖先节点比较出的最大差值，遍历完所有节点后就可以得出最大情况。
 *    递归函数返回三个值：子树节点最大值、子树节点最小值、子树最大差值。空节点返回 null， 叶子节点返回(val,val,0)。优化空间复杂度，使用固定数组保存结果。
 *
 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
//        return dfs2(root)[2];
    }

    // 递
    private int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }
        int a = Math.max(Math.abs(min - root.val), Math.abs(max - root.val));
        min = Math.min(min ,root.val);
        max = Math.max(max, root.val);
        return Math.max(a, Math.max(dfs(root.left, min, max), dfs(root.right, min, max)));
    }

    // 归
    private int[] dfs2(TreeNode root, int[] res) {
        if (root == null) {
            return null;
        }
        if (root.left == root.right) {
            res[0] = root.val;
            res[1] = root.val;
            res[2] = 0;
            return res;
        }
        int min = Integer.MAX_VALUE, max = 0, subDiff = 0;
        if (root.left != null) {
            int[] ints = dfs2(root.left, res);
            max = Math.max(max, ints[0]);
            min = Math.min(min, ints[1]);
            subDiff = Math.max(subDiff, ints[2]);
        }
        if (root.right != null) {
            int[] ints = dfs2(root.right, res);
            max = Math.max(max, ints[0]);
            min = Math.min(min, ints[1]);
            subDiff = Math.max(subDiff, ints[2]);
        }
        int maxDiff = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        maxDiff = Math.max(maxDiff, subDiff);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        res[0] = max;
        res[1] = min;
        res[2] = maxDiff;
        return res;
    }
}
