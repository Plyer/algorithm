package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 92. 反转链表 II
 *
 * 1. head 节点可能被反转，所以创建 dummy 节点。
 * 2. 循环找到 left-1 的节点 p，对 [left,right] 的链表进行反转，令 left 所在节点的 next 指向 right+1 即 p.next.next=cur，令 p 的 next 节点指向反转后的头节点即 p.next=pre。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        for (int i = 1; i <= left - 1; i++) {
            p = p.next;
        }

        ListNode pre = null, cur = p.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        p.next.next = cur;
        p.next = pre;
        return dummy.next;
    }
}
