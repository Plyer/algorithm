package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 86. 分隔链表
 *
 * 交换节点：
 * 1. 头结点可能改变，创建 dummy。
 * 2. 定义 p=dummy，cur=dummy，当 cur.next!=null 时进行循环：如果 cur.next.val<x，将其移动到 p.next，cur 和 p 都往后移动。
 *
 * 重新构建新链表：枚举链表把 val<x 的节点移动到新链表，并把剩余接电脑连接到新链表尾部。
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head), p = dummy, pNext = head, cur = dummy, nxt = null;
        while (cur.next != null) {
            if (cur.next.val < x) {
                if (cur.next == p.next) {
                    cur = cur.next;
                    p = p.next;
                    continue;
                }
                nxt = cur.next;
                cur.next = cur.next.next;
                pNext = p.next;
                p.next = nxt;
                nxt.next = pNext;

                p = p.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0, head), p1 = dummy1, dummy2 = new ListNode(), p2 = dummy2, nxt1 = null;
        while (p1.next != null) {
            if (p1.next.val < x) {
                nxt1 = p1.next;
                p1.next = p1.next.next;
                p2.next = nxt1;
                nxt1.next = null;
                p2 = p2.next;
            } else {
                p1 = p1.next;
            }
        }

        p2.next = dummy1.next;
        return dummy2.next;
    }
}
