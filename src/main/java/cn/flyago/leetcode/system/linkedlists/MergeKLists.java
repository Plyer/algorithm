package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt((ListNode a) -> a.val));
        Arrays.stream(lists).filter(Objects::nonNull).forEach(q::add);

        ListNode dummy = new ListNode(), p = dummy;
        while (!q.isEmpty()) {
            ListNode poll = q.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null) {
                q.add(poll.next);
            }
        }
        return dummy.next;
    }
}
