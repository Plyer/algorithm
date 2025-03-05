package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2130. 链表最大孪生和
 *
 * 快慢指针：使用快慢指针法对前半链表进行反转，然后枚举反转后的前半链表加上原始的后半链表，求最大和。
 */
public class PairSum {
    public int pairSum(ListNode head) {
        ListNode pre = null, slow = head, fast = head, nxt = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            nxt = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nxt;
        }

        int res = 0;
        while (slow != null) {
            res = Math.max(res, slow.val + pre.val);
            slow = slow.next;
            pre = pre.next;
        }
        return res;
    }
}
