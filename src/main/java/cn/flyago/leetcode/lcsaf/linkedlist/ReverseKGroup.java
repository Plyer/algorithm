package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 25. K 个一组翻转链表
 *
 * 反转链表：
 * 1. 头节点可能发生改变，创建 dummy，定义 p=dummy。
 * 2. 首先遍历一次链表求出长度 n，当 n>=k 时进入循环：n-=k，对 p 之后的 k 个节点进行反转并连接，移动 p。
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, n++) {}

        ListNode cur = null, pre = null, nxt = null, t = null;
        while (n >= k) {
            n -= k;
            pre = null;
            cur = p.next;
            for (int i = 0; i < k; i++) {
                nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }

            t = p.next;
            p.next.next = cur;
            p.next = pre;
            p = t;
        }
        return dummy.next;
    }
}
