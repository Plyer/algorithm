package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 3217. 从链表中移除在数组中存在的节点
 *
 * 删除链表：
 * 1. 头节点可能删除，创建 dummy 虚拟头节点。
 * 2. 对数组进行计数排序生成 freq[]。
 * 3. 定义 p=dummy，当 p.next!=null 时如果 freq[p.next.val]>0 则删除 p.next，否则 p=p.next。
 */
public class ModifiedList {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        int[] freq = new int[100001];
        for (int num : nums) {
            freq[num]++;
        }
        while (p.next != null) {
            if (freq[p.next.val] > 0) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
