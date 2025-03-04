package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2095. 删除链表的中间节点
 *
 * 快慢指针：
 * 1. 头节点可能被删除并且需要找到中间节点的前一个节点，创建 dummy。
 * 2. 定义 slow=dummy，fast=head，当 fast!=null && fast.next!=null 时，slow=slow.next fast=fast.next.next。循环结束后的 slow 就是待删除节点的前驱节点。
 */
public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head), slow = dummy, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
