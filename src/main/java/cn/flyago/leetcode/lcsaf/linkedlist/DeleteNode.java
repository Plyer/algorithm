package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 237. 删除链表中的节点
 *
 * 删除链表：脑筋急转弯，把 node 值改为 node.next 的值，删除 node.next。
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
