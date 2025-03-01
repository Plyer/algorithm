package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2487. 从链表中移除节点
 *
 * 删除链表：
 * 1. 头节点可能被删除，创建 dummy。
 * 2. 定义 cur=dummy.next, 当前已接入链表的最小值 min。当 cur.next!=null 时：如果 cur.next.val>min, 从 dummy.next 开始删除 val<cur.next.val 的节点；min=cur.next.val,cur=cur.next。
 *
 * 优化1：反转链表后从右到左删除比当前节点更小的元素，最后反转回来。
 * 优化2：使用递归。
 */
public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int min = head.val;
        for (ListNode cur = head; cur.next != null; cur = cur.next) {
            if (cur.next.val > min) {
                ListNode p = dummy;
                while (p.next.val >= cur.next.val) {
                    p = p.next;
                }
                p.next = cur.next;
            }
            min = cur.next.val;
        }
        return dummy.next;
    }

    public ListNode removeNodes2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = removeNodes2(head.next); // 返回的 node 一定是子链表最大值
        if (node != null && node.val > head.val) {
            return node; // 删除 head
        }
        head.next = node;
        return head;
    }
}
