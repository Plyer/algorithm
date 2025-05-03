package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * DFS + 哈希表：使用 DFS 生成并保存子树序列化字符串，并把序列化串放进哈希表计数，数量超过 1 的子树保存到结果。
 */
public class FindDuplicateSubtree {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    private String dfs(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append("_").append(dfs(root.right));
        if (map.merge(sb.toString(), 1, Integer::sum) == 2) {
            res.add(root);
        }
        return sb.toString();
    }
}
