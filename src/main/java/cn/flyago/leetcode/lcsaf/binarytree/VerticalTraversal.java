package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 987. 二叉树的垂序遍历
 * <p>
 * 层序遍历，记录行号和列号，遍历完一层后按列号分组排序，然后加入结果
 */
public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<TreeNode> a = new ArrayList<>();
        List<TreeNode> b = new ArrayList<>();
        Map<TreeNode, Integer> node2Col = new HashMap<>();
        Map<Integer, List<Integer>> col2List = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        a.add(root);
        node2Col.put(root, 0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!a.isEmpty()) {
            Map<Integer, List<TreeNode>> collect = a.stream().collect(Collectors.groupingBy(i -> node2Col.get(i)));
            for (Map.Entry<Integer, List<TreeNode>> entry : collect.entrySet()) {
                Integer col = entry.getKey();
                min = Math.min(min, col);
                max = Math.max(max, col);
                List<TreeNode> value = entry.getValue();
                value.sort(Comparator.comparing(i -> i.val));
                col2List.putIfAbsent(col, new ArrayList<>());
                col2List.get(col).addAll(value.stream().map(n -> n.val).toList());
            }
            b = new ArrayList<>();
            for (TreeNode node : a) {
                Integer col = node2Col.get(node);
                if (node.left != null) {
                    b.add(node.left);
                    node2Col.put(node.left, col - 1);
                }
                if (node.right != null) {
                    b.add(node.right);
                    node2Col.put(node.right, col + 1);
                }
            }
            a = b;
        }

        for (int i = min; i <= max; i++) {
            res.add(col2List.get(i));
        }
        return res;
    }

    int min = Integer.MAX_VALUE;

    public List<List<Integer>> verticalTraversal2(TreeNode root) {
        Map<Integer, List<int[]>> col2RowAndVal = new HashMap<>();
        dfs(root, 0, 0, col2RowAndVal);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i < min + col2RowAndVal.size(); i++) {
            List<int[]> ints = col2RowAndVal.get(i);
            ints.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            res.add(ints.stream().map(arr -> arr[1]).collect(Collectors.toList()));
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int col, Map<Integer, List<int[]>> col2RowAndVal) {
        if (root == null) return;
        min = Math.min(min, col);
        col2RowAndVal.putIfAbsent(col, new ArrayList<>());
        col2RowAndVal.get(col).add(new int[]{row, root.val});
        dfs(root.left, row + 1, col - 1, col2RowAndVal);
        dfs(root.right, row + 1, col + 1, col2RowAndVal);
    }
}
