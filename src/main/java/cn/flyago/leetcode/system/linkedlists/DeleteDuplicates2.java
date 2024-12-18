package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 83 删除排序链表中的重复元素
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head), p = head, x = head.next;
        for (; x != null; x = x.next) {
            if (x.val != p.val) {
                p.next = x;
                p = p.next;
            }
        }
        p.next = null;
        return dummy.next;
    }
}
