package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2074. 反转偶数长度组的节点
 *
 * 反转链表：
 * 1. 定义 p=head i=2，当 p.next!=null 时进入循环：如果 i 是偶数，对 p 之后的 i 个节点（可能小于 i）反转后接入，移动 p。
 * 2. 特殊情况，最后一段的长度是偶数但序列是奇数或者序列是偶数但是长度是奇数，这时要对最后一组再次进行反转。
 */
public class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode p = head, preP = null, pre = null, cur = null, nxt = null, t = null;
        int lastLen = 0, i = 2;
        while (p.next != null) {
            preP = p;
            lastLen = 0;
            if (i % 2 == 0) {
                pre = null;
                cur = p.next;
                for (int j = 0; j < i && cur != null; j++, lastLen++) {
                    nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                t = p.next;
                p.next.next = cur;
                p.next = pre;
                p = t;
            } else {
                for (int j = 0; j < i && p.next != null; j++, lastLen++) {
                    p = p.next;
                }
            }
            i++;
        }

        if (preP == null) {
            return head;
        }

        i--;
        if (i % 2 == 0 && lastLen % 2 == 1 || i % 2 == 1 && lastLen % 2 == 0) {
            pre = null;
            cur = preP.next;
            while (cur != null) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            preP.next.next = cur;
            preP.next = pre;
        }
        return head;
    }

    public static void main(String[] args) {
        new ReverseEvenLengthGroups().reverseEvenLengthGroups(new ListNode(1, new ListNode(1, new ListNode(0, new ListNode(6)))));
    }
}
