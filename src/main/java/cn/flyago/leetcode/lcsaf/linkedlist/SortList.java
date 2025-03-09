package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 148. 排序链表
 *
 * 用快排超时，改为归并：先找到中间节点的前驱节点，然后断开链表，对其分别排序后合并。
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = new ListNode(0, head), fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = sortList(slow.next);
        slow.next = null;
        ListNode list2 = sortList(head);

        ListNode dummy = new ListNode(), p = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                p.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                p.next = list1;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

//    private void sortList(ListNode head, ListNode end) {
//        if (head == null || head.next == null || head == end || head.next == end) {
//            return;
//        }
//        ListNode p = help(head, end);
//        sortList(head, p);
//        sortList(p.next, end);
//    }
//
//    private ListNode help(ListNode head, ListNode end) {
//        int base = head.val;
//        ListNode lt = head;
//        // 循环不变量：
//        // [head.next, lt] < base
//        // [lt.next, end) >= base
//        for (ListNode cur = head; cur.next != end; cur = cur.next) {
//            if (cur.next.val < base) {
//                int t = cur.next.val;
//                cur.next.val = lt.next.val;
//                lt.next.val = t;
//                lt = lt.next;
//            }
//        }
//
//        head.val = lt.val;
//        lt.val = base;
//        return lt;
//    }
}
