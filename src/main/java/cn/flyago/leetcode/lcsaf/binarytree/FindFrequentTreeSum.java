package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 *
 * 在外部维护一个哈希表保存子树元素和及其个数。
 * 定义一个递归函数求子树元素和，在函数中记录左子树元素和、右子树元素和、当前树元素和到哈希表中。
 */
public class FindFrequentTreeSum {
    Map<Integer, Integer> sum2Cnt = new HashMap<>();
    int maxCnt;
    List<Integer> res = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        treeSum(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + treeSum(root.left) + treeSum(root.right);
        int newCnt = sum2Cnt.merge(sum, 1, Integer::sum);
        if (newCnt > maxCnt) {
            maxCnt = newCnt;
            res = new ArrayList<>();
            res.add(sum);
        } else if (newCnt == maxCnt) {
            res.add(sum);
        }
        return sum;
    }
}
