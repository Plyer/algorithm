package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 445. 两数相加 II
 *
 * 反转链表后按低位相加后进位的方式求。
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(3), p = head;
        for (int i = 0; i < 9; i++) {
            p.next = new ListNode(9);
            p = p.next;
        }
        System.out.println(new AddTwoNumbers2().addTwoNumbers(new ListNode(7), head));
    }
}
