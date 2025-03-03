package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 前后指针：要删除倒数第 N 个节点那就需要拿到倒数第 N+1 个节点。
 * 1. 头节点可能被删除，创建 dummy。
 * 2. 定义 r=dummy，r 往右移动 N 步，定义 l=dummy，此时 l r 同时往右移动直到 r 到达末尾，此时 l 处于倒数第 N+1 个节点。
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head), l = dummy, r = dummy;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
