package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 86 分隔链表
 */
public class Partition {
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode small = new ListNode();
        ListNode smallDummy = small;
        ListNode bigOrEq = new ListNode();
        ListNode bigOrEqDummy = bigOrEq;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                small.next = node;
                small = small.next;
            } else {
                bigOrEq.next = node;
                bigOrEq = bigOrEq.next;
            }
            node = node.next;
        }

        small.next = bigOrEqDummy.next;
        bigOrEq.next = null;
        return smallDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode partition = partition(head, 3);
        while (partition != null) {
            System.out.printf("%d,", partition.val);
            partition = partition.next;
        }
    }
}
