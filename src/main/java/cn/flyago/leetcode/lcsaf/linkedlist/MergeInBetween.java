package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 1669. 合并两个链表
 *
 * 删除链表：枚举 list1 找到 a-1 和 b+1 所在的节点 l 和 r，枚举 list2 找到末尾节点 tail，l.next=list2.head，tail.next=r。
 */
public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l = null, r = null;
        int i = 0;
        for (ListNode cur = list1; cur != null; cur = cur.next, i++) {
            if (i == a - 1) {
                l = cur;
            }
            if (i == b + 1) {
                r = cur;
                break;
            }
        }

        ListNode tail = list2;
        while (tail.next != null) {
            tail = tail.next;
        }
        l.next = list2;
        tail.next = r;
        return list1;
    }
}
