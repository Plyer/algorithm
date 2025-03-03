package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 61. 旋转链表
 *
 * 前后指针：枚举链表拿到长度 n，并把链表的尾部指向头部形成循环链表，m=k%n，如果 m=0 则无需旋转，否则找到倒数第 m+1 个节点，把其 next 断开，这个 next 就是旋转后的链表头节点。
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        int m = k % n;
        if (m == 0) {
            return head;
        }

        ListNode l = head, r = head;
        while (m-- > 0) {
            r = r.next;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }

        tail.next = head;
        head = l.next;
        l.next = null;
        return head;
    }
}
