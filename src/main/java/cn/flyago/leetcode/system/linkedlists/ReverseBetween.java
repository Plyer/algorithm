package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 92 反转链表 Ⅱ
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPre = new ListNode(0, head), dummy = leftPre;
        // 找到位置=left-1的节点
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
        }

        // 反转left到right的链表
        ListNode leftNode = leftPre.next, l = leftNode, r = leftNode.next;
        l.next = null;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = r.next;
            r.next = l;
            l = r;
            r = temp;
        }

        // 拼接left前的链表加反转后的链表加末尾的链表
        leftPre.next = l;
        leftNode.next = r;
        return dummy.next;
    }
}
