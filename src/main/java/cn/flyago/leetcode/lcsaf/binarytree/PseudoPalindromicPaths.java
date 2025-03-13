package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1457. 二叉树中的伪回文路径
 * <p>
 * 递：枚举。使用哈希表保存路径中值的数量，使用一个变量 c 保存数量为奇数的 key 数量，当到达叶子节点时：如果 c==0||c==1，此路径是伪回文路径，否则不是。
 * <p>
 * 灵神题解：值范围在 1-9，所以可以使用数组来保存节点值数量，进一步简化可以保存节点值数量的奇偶数，奇数存 1，偶数存 0，再进一步可以把这个数组保存为一个二进制数。
 *          分解子问题，二叉树的伪回文路径数量是左子树的伪回文路径数量加上右子树的伪回文路径数量，递归参数中增加节点值数量状态。
 */
public class PseudoPalindromicPaths {
    int c, res;

    public int pseudoPalindromicPaths(TreeNode root) {
        Map<Integer, Integer> val2Cnt = new HashMap<>();
        dfs(root, val2Cnt);
        return res;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> val2Cnt) {
        if (root == null) {
            return;
        }
        Integer newVal = val2Cnt.merge(root.val, 1, Integer::sum);
        final int tc = c;
        if (newVal % 2 == 0) {
            c--;
        } else {
            c++;
        }
        if (root.left == null && root.right == null && (c == 0 || c == 1)) {
            res++;
        }
        dfs(root.left, val2Cnt);
        dfs(root.right, val2Cnt);
        c = tc;
        if (val2Cnt.merge(root.val, -1, Integer::sum) == 0) {
            val2Cnt.remove(root.val);
        }
    }

    // 灵神题解
    public int pseudoPalindromicPaths2(TreeNode root) {
        int mask = 0; // 一开始所有节点值数量都是 0
        return dfs2(root, mask);
    }

    /**
     * 求二叉树的伪回文路径数量
     * @param root
     * @param mask 根节点到父节点的节点值奇偶数量二进制数
     * @return
     */
    private int dfs2(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }
        mask ^= 1 << root.val; // 每个值占据一个二进制位，跟原值异或即可得到最新的奇偶数量。
        if (root.left == root.right && Integer.bitCount(mask) <= 1) { // 当前是叶子节点并且奇数数量为1或0，此时是伪回文路径
            return 1;
        }
        return dfs2(root.left, mask) + dfs2(root.right, mask);
    }
}
