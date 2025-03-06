package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 160. 相交链表
 *
 * 遍历链表 A 的时候把链表 B 拼接到 链表 A 后面，在遍历 A 的同时遍历 B 并把 A 拼接在 A 后面，如果有相交点就会相遇。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int c = 0;
        while (p1 != p2 && c < 3) {
            p1 = p1.next;
            if (p1 == null) {
                p1 = headB;
                c++;
            }
            p2 = p2.next;
            if (p2 == null) {
                p2 = headA;
                c++;
            }
        }
        return p1 == p2 ? p1 : null;
    }
}
