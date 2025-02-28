package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2181. 合并零之间的节点
 *
 * 链表：定义 dummy 节点、p=dummy、node=head.next，当 node!=null 时枚举链表，求节点和，当遇见节点值为 0 时 p.next=new Node(sum) sum=0。
 * 优化空间复杂度：把和保存到前一个 0 节点。
 */
public class MergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy, node = head.next;
        int sum = 0;
        while (node != null) {
            sum += node.val;
            if (node.val == 0) {
                p.next = node;
                node.val = sum;
                sum = 0;
                p = p.next;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public ListNode mergeNodes2(ListNode head) {
        ListNode node = head.next, p = head;
        while (node.next != null) {
            p.val += node.val;
            if (node.val == 0) {
                p = p.next;
                p.val = 0;
            }
            node = node.next;
        }
        p.next = null;
        return head;
    }
}