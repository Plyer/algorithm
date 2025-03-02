package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2807. 在链表中插入最大公约数
 *
 * 链表插入节点：
 * 定义 cur=head，当 cur.next!=null 时，求 cur.val 和 cur.next.val 的最大公约数，插入 cur 后面，移动 cur=cur.next.next。
 */
public class InsertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        for (ListNode cur = head; cur.next != null; cur = cur.next.next) {
            cur.next = new ListNode(gcd(cur.val, cur.next.val), cur.next);
        }
        return head;
    }

    // 辗转相除法求最大公约数。如果 a>b，第一次循环交换 a b 的位置，否则辗转相除直到 a=0。
    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
