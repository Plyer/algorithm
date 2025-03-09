package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 *
 * 前缀和加哈希。
 */
public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head), p = head;
        map.put(0, dummy);
        while (p != null) {
            int key = list.getLast() + p.val;
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                int c = 0;
                while (node.next != p.next) {
                    node.next = node.next.next;
                    c++;
                }
                for (int i = 0; i < c - 1; i++) {
                    map.remove(list.getLast());
                    list.removeLast();
                }
            } else {
                list.add(key);
                map.put(key, p);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        new RemoveZeroSumSublists().removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4))))));
    }
}
