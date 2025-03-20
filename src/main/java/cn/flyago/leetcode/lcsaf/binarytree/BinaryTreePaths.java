package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String str, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == root.right) {
            if (str.isEmpty()) {
                res.add(String.valueOf(root.val));
            } else {
                res.add(str + "->" + root.val);
            }
            return;
        }
        final int len = str.length();
        if (!str.isEmpty()) {
            str += "->";
        }
        str += root.val;
        dfs(root.left, str, res);
        dfs(root.right, str, res);
    }
}
