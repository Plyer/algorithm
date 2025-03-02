package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 147. 对链表进行插入排序
 *
 * 链表插入节点：
 * 1. 第一个元素可能改变，所以创建 dummy。
 * 2. 定义 cur=head，当 cur.next!=null 时，从 dummy.next 开始遍历找到大于等于 cur.next.val 的前一个节点 node，把这个节点插入到 node 之后。
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < cur.next.val) {
                node = node.next;
            }
            if (node == cur) {
                cur = cur.next;
                continue;
            }
            // 把 cur.next 插入到 node.next
            ListNode tempCurNxt = cur.next, tempNodeNxt = node.next;
            cur.next = cur.next.next;
            node.next = tempCurNxt;
            tempCurNxt.next = tempNodeNxt;
        }
        return dummy.next;
    }
}
