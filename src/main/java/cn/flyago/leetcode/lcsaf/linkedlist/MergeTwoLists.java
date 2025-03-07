package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * 双指针遍历链表，把较小值添加到新链表，移动指针。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
}
