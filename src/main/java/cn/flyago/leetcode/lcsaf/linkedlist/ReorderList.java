package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 143. 重排链表
 *
 * 快慢指针：对链表中间节点以及之后的节点进行反转得到 pre，当 pre.next!=null 时，把反转后的链表节点连接到头节点之后，然后分别移动两个链表节点。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode nxt = head.next, nxt2 = pre.next;
        while (pre.next != null) {
            head.next = pre;
            pre.next = nxt;
            pre = nxt2;
            head = nxt;
            nxt = head.next;
            nxt2 = pre.next;
        }
    }
}
