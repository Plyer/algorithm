package cn.flyago.leetcode.lcsaf.binarytree;

/**
 * 559. N 叉树的最大深度
 */
public class MaxDepth2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int h = 0;
        for (Node child : root.children) {
            h = Math.max(h, maxDepth(child));
        }
        return h + 1;
    }
}
