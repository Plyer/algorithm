package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 328. 奇偶链表
 *
 *  定义 cur=head, nextJi=head.next.next，当 nextJi!=null 时，缓存 nextJi 的下一个数和下一个奇数，把 nextJi 移动到 cur 后面，cur和nextJi和 preNextJi 都往后移动。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, nxt = cur.next;
        ListNode preNextJi = cur.next, nextJi = cur.next.next, nextJiNext = null;
        while (nextJi != null) {
            nextJiNext = nextJi.next;
            preNextJi.next = preNextJi.next.next;

            nxt = cur.next;
            cur.next = nextJi;
            nextJi.next = nxt;

            cur = cur.next;
            preNextJi = nextJiNext;
            nextJi = preNextJi == null ? null : preNextJi.next;
        }
        return head;
    }
}
