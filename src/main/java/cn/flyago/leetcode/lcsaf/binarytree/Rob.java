package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * <p>
 * 分解子问题：把二叉树分成三部分，打劫的情况分两种：
 * 1. 打劫根节点，那左右子树的根节点就不能被打劫，求出这种情况下左右子树的打劫最大值，加上当前根节点值。
 * 2. 不打劫根节点，求左右子树打劫最大值。
 * 3. 对上述两种情况求最大值。
 * <p>
 * 优化：把打劫根节点和不打劫根节点的情况都作为递归返回值。
 */
public class Rob {
    public int rob(TreeNode root) {
        Map<TreeNode, int[]> dp = new HashMap<>();
        return rob(root, true, dp);
    }

    public int rob2(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0}; // 节点值为空时不管打不打劫都是 0。
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int rob = root.val + left[0] + right[0]; // 打劫根节点时，左右子树选择不打劫的情况
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不打劫根节点时，左右子树均可打劫可不打劫其根节点，那就选择两种情况中的最大值。
        return new int[]{notRob, rob};
    }

    private int rob(TreeNode root, boolean canRobRoot, Map<TreeNode, int[]> dp) {
        if (root == null) {
            return 0;
        }
        int[] cache = dp.get(root);
        if (cache != null && cache[canRobRoot ? 1 : 0] != -1) {
            return cache[canRobRoot ? 1 : 0];
        }

        // 不能打劫根节点的情况
        int left = rob(root.left, true, dp);
        int right = rob(root.right, true, dp);
        int res = left + right;

        if (canRobRoot) { // 可以打劫根节点的情况下分两种，打劫根节点和不打劫根节点
            // 打劫根节点
            int robRoot = root.val + rob(root.left, false, dp) + rob(root.right, false, dp);
            // 不打劫根节点
            res = Math.max(robRoot, res);
        }

        if (cache == null) {
            cache = new int[]{-1, -1};
            dp.put(root, cache);
        }
        cache[canRobRoot ? 1 : 0] = res;
        return res;
    }
}
