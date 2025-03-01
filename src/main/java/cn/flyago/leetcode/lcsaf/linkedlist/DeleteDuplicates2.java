package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 删除链表：
 * 1. 头节点可能被删除，创建 dummy 节点。
 * 2. 定义 cur=dummy。当 cur.next 和 cur.next.next 都不为 null 时：如果 cur.next.val==cur.next.next.val，删除所有值为上述 val 的节点；否则 cur=cur.next。
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int v = cur.next.val;
                while (cur.next != null && cur.next.val == v) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
