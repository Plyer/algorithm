package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 988. 从叶结点开始的最小字符串
 * <p>
 * 递：枚举，在递归函数中传递上级字符串，当遇到叶子节点时此字符串有效，跟结果对比取更小的字符串。
 */
public class SmallestFromLeaf {
    String res = "";
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode root, String str) {
        if (root == null) {
            return "";
        }
        str = Character.toString('a' + root.val) + str;
        if (root.left == root.right) {
            return str;
        }
        String left = dfs(root.left, str);
        String right = dfs(root.right, str);
        return compare(left, right) < 0 ? left : right;
    }

    private int compare(String a, String b) {
        if (a == "") {
            return 1;
        }
        if (b == "") {
            return -1;
        }
        return a.compareTo(b);
    }

    public static void main(String[] args) {
        System.out.println("".compareTo("a"));
    }
}
