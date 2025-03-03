package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 206. 反转链表
 *
 * 定义 cur=head，反转 cur 的 next，需要先缓存 nxt=cur.next，然后把 cur 的 next 指针改为前一个节点 pre，修改完成后 pre=cur cur=nxt，一直循环直到 cur=null，反转后的链表头就是 pre。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
