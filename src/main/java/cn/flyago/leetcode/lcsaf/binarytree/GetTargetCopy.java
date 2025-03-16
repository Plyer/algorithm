package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 1379. 找出克隆二叉树中的相同节点
 * <p>
 * 1. 枚举解法，现在原二叉树找到 target 的先序遍历索引，然后先序遍历 cloned 找到对应索引的节点。
 * 2. 灵神题解：直接在 getTargetCopy 内部执行先序遍历，当在 original 找到 target 时 cloned 就是对应的目标节点。
 */
public class GetTargetCopy {
    boolean end;
    int i, targetIdx;

    // 灵神题解
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned; // 当 original=null 时 clone 也等于 null，所以也可以返回 cloned。
        }
        TreeNode res = getTargetCopy2(original.left, cloned.left, target);
        if (res != null) {
            return res;
        }
        res = getTargetCopy2(original.right, cloned.right, target);
        return res;
    }


    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, target, -1);
        i = 0;
        end = false;
        return dfs(cloned, target, targetIdx);
    }

    private TreeNode dfs(TreeNode cloned, TreeNode target, final int idx) {
        if (cloned == null || end) {
            return null;
        }
        final int curIdx = i;
        i++;
        if (cloned.val == target.val || idx == i) {
            end = true;
            targetIdx = curIdx;
            return cloned;
        }

        TreeNode left = dfs(cloned.left, target, idx);
        if (left != null) {
            end = true;
            targetIdx = curIdx;
            return left;
        }
        TreeNode right = dfs(cloned.right, target, idx);
        if (right != null) {
            end = true;
            targetIdx = curIdx;
        }
        return right;
    }
}
