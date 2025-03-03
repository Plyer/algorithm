package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * 反转链表：
 * 1. 头节点可能发生改变，创建 dummy。
 * 2. 定义 p=dummy，当 p 后面两个节点存在时对其进行反转后连接。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode pre = null, cur = p.next;
            for (int i = 0; i < 2; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode t = p.next;
            p.next.next = cur;
            p.next = pre;
            p = t;
        }
        return dummy.next;
    }
}
