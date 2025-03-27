package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.*;

/**
 * 2196. 根据描述创建二叉树
 *
 * 使用哈希表 val2Node 保存已生成的节点，枚举二维数组：去哈希表中寻找当前数组的节点，如果找到按规则拼接，如果没找到则创建树并加入哈希表。
 * 枚举过程中同时记录没有父节点的值，枚举完成后这个值就是根节点。
 */
public class CreateBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> val2Node = new HashMap<>();
        Set<Integer> childVals = new HashSet<>();
        for (int[] arr : descriptions) {
            int parentVal = arr[0];
            int childVal = arr[1];
            childVals.add(childVal);
            boolean isLeft = arr[2] == 1;
            TreeNode parent = val2Node.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = val2Node.computeIfAbsent(childVal, TreeNode::new);
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : val2Node.entrySet()) {
            if (!childVals.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
