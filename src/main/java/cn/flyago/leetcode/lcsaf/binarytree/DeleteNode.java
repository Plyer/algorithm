package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * 由于根节点可能被删除，所以创建 dummy 节点。
 * 找到待删除节点后分情况讨论：
 * 1. 待删除节点是叶子节点，直接删除。
 * 2. 待删除节点仅包含左子树或右子树，把剩余的子树连接到 pre。
 * 3. 把左子树连接到 pre，右子树连接到左子树的最右侧。
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE, null, root);
        TreeNode pre = dummy, cur = root;
        boolean isLeft = false;
        while (cur != null && cur.val != key) {
            pre = cur;
            if (key > cur.val) {
                cur = cur.right;
                isLeft = false;
            } else {
                cur = cur.left;
                isLeft = true;
            }
        }
        if (cur == null) {
            return root;
        }

        TreeNode next = null;
        if (cur.left != null) {
            next = cur.left;
        } else {
            next = cur.right;
        }

        if (isLeft) {
            pre.left = next;
        } else {
            pre.right = next;
        }
        if (cur.right != null && next != cur.right) {
            TreeNode right = cur.right;
            pre = next;
            cur = pre.right;
            while (cur != null) {
                pre = cur;
                cur = cur.right;
            }
            pre.right = right;
        }

        return dummy.right;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        new DeleteNode().deleteNode(tree, 5);
    }
}
