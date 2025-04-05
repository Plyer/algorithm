package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 449. 序列化和反序列化二叉搜索树
 *
 * 序列化：先序遍历
 * 反序列化：数组头是 root，往右遍历找到大于 root 值的索引 i，[1,i) 是左子树，[i,len) 是右子树。
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        dfs(root, s);
        return s.deleteCharAt(s.length() - 1).toString();
    }

    private void dfs(TreeNode root, StringBuilder s) {
        if (root == null) {
            return;
        }
        s.append(root.val);
        s.append(",");
        dfs(root.left, s);
        dfs(root.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String[] arr = data.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int s, int e) {
        if (s >= e) {
            return null;
        }
        TreeNode root = new TreeNode(nums[s]);
        int k = s + 1;
        while (k < e && nums[k] < nums[s]) {
            k++;
        }
        root.left = build(nums, s + 1, k);
        root.right = build(nums, k, e);
        return root;
    }

}
