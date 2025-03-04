package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 876. 链表的中间结点
 *
 * 快慢指针：slow=fast=head，当 fast!=null && fast.next!=null 时 slow 走一不、fast 走两步。
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
