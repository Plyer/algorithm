package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.ListNode;
import cn.flyago.leetcode.base.TreeNode;

/**
 * 1367. 二叉树中的链表
 * <p>
 * 暴力解法 https://leetcode.cn/problems/linked-list-in-binary-tree/solutions/3034003/dan-di-gui-xie-fa-pythonjavacgo-by-endle-00js/
 */
public class IsSubPath {
    ListNode head;

    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        return dfs(head, root);
    }

    private boolean dfs(ListNode s, TreeNode t) {
        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }

        return (s.val == t.val && (dfs(s.next, t.left) || dfs(s.next, t.right))) ||
                (s == head && (dfs(s, t.left) || dfs(s, t.right)));
    }
}
