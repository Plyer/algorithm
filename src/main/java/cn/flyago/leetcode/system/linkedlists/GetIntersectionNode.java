package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 160 相交链表
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        int count = 0;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null) {
                if (++count == 2) {
                    return null;
                }
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }

    static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(2, null);
        ListNode headB = new ListNode(1, null);
        System.out.println(getIntersectionNode2(headA, headB));
        System.out.println(null == null);
    }
}
