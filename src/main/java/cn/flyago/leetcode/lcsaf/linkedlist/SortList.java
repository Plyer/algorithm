package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 148. 排序链表
 *
 * 用快排超时
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        sortList(head, null);
        return head;
    }

    private void sortList(ListNode head, ListNode end) {
        if (head == null || head.next == null || head == end || head.next == end) {
            return;
        }
        ListNode p = help(head, end);
        sortList(head, p);
        sortList(p.next, end);
    }

    private ListNode help(ListNode head, ListNode end) {
        int base = head.val;
        ListNode lt = head;
        // 循环不变量：
        // [head.next, lt] < base
        // [lt.next, end) >= base
        for (ListNode cur = head; cur.next != end; cur = cur.next) {
            if (cur.next.val < base) {
                int t = cur.next.val;
                cur.next.val = lt.next.val;
                lt.next.val = t;
                lt = lt.next;
            }
        }

        head.val = lt.val;
        lt.val = base;
        return lt;
    }
}
