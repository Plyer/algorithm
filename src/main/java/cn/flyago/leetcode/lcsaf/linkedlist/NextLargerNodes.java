package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            ListNode p = cur.next;
            while (p != null && p.val <= cur.val) {
                p = p.next;
            }
            list.add(p == null ? 0 : p.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
