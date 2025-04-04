package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.ListNode;
import cn.flyago.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return build(list, 0, list.size());
    }

    private TreeNode build(List<Integer> list, int s, int e) {
        if (s >= e) {
            return null;
        }
        if (e == s + 1) {
            return new TreeNode(list.get(s));
        }
        int mid = s + (e - s) / 2;
        return new TreeNode(list.get(mid), build(list, s, mid), build(list, mid + 1, e));
    }
}
