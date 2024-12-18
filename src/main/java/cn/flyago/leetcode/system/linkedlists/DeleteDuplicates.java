package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 82 删除排序链表中的重复元素 Ⅱ
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, head), dp = dummy, p = head.next;
        while (p != null) {
            for (; p != null && p.val == dp.next.val; p = p.next) {}
            if (p != dp.next.next) {
                dp.next = p;
            } else {
                dp = dp.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, null), dp = dummy, slow = head, fast = head;
        for (; fast != null; fast = fast.next) {
            // 找到快慢指针不相等的节点，如果快指针在慢指针之后表示慢指针元素不重复
            if (fast.val != slow.val) {
                if (fast == slow.next) {
                    dp.next = slow;
                    dp = dp.next;
                }
                slow = fast;
            }
        }
        // 最后一个节点是不重复节点时 fast=null 会被循环漏掉，这里进行补充
        if (fast == slow.next) {
            dp.next = slow;
            dp = dp.next;
        }
        dp.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode listNode = new DeleteDuplicates().deleteDuplicates(test);
        while (listNode != null) {
            System.out.printf("%d,", listNode.val);
        }
    }
}
