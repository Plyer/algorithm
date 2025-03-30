package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2583. 二叉树中的第 K 大层和
 *
 * 层序遍历把每层的和记录到数组，如果数组长度小于 K 返回 -1，否则排序后返回 len-k 所在的和。
 */
public class KthLargestLevelSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Long> sums = new ArrayList<>();
        for (int len = queue.size(); len > 0; len = queue.size()) {
            long sum = 0;
            while (len-- > 0) {
                TreeNode node = queue.pollFirst();
                sum += node.val;
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            sums.add(sum);
        }
        if (k > sums.size()) {
            return -1;
        }
        Collections.sort(sums);
        return sums.get(sums.size() - k);
    }
}
