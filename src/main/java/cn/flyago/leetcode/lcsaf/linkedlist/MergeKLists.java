package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 *
 * 把链表放进小顶堆里，从堆里取出最小的链表节点加入到新链表，剩下的节点放回堆。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) pq.add(list);
        }

        ListNode dummy = new ListNode(), p = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            if (poll.next != null) pq.add(poll.next);
            poll.next = null;
            p.next = poll;
            p = p.next;
        }
        return dummy.next;
    }
}
