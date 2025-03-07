package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2816. 翻倍以链表形式表示的数字
 *
 * 反转链表后对每个节点乘以 2 保存余数为新节点，保存商为进位，最后反转链表。
 */
public class DoubleIt {
    public ListNode doubleIt(ListNode head) {
        if (head.val == 0) return head;
        head = reverse(head);
        ListNode dummy = new ListNode(), p = dummy;
        int carry = 0;
        while (head != null || carry != 0) {
            int doubleVal = (head == null ? 0 : head.val) * 2 + carry;
            p.next = new ListNode(doubleVal % 10);
            p = p.next;
            carry = doubleVal / 10;
            if (head != null) head = head.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
