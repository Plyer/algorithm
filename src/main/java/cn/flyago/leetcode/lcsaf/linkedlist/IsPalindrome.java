package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 234. 回文链表
 *
 * 快慢指针：使用快慢指针法找到中间节点 midNode 并获得链表中间节点的长度，定义 left=head，right=midNode，如果中间节点长度为奇数，对 right.next 进行反转否则反转 right，然后进行比较。
 * 优化：慢指针走的过程中就进行反转，到达中间节点之后再进行比较。
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转 slow
        ListNode pre = null, cur = slow, nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        // 从头开始比较
        while (head != slow) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode pre = null, slow = head, fast = head, nxt = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            nxt = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nxt;
        }

        if (fast != null) {
            // 此时链表长度为奇数
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        new IsPalindrome().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }
}
