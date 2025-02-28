package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2058. 找出临界点之间的最小和最大距离
 *
 * 链表：定义三个节点 a=head b=head.next c=b.next，定义索引 i=1, fi=0, last=0, min=MaxValue，当 c!=null 时，判断 b 是否满足要求，如果满足要求则按要求保存 fi last min，更新 a b c。
 */
public class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a = head, b = head.next, c = head.next.next;
        int first = 0, last = 0, min = Integer.MAX_VALUE;
        for (int i = 1; c != null; i++) {
            if ((b.val > a.val && b.val > c.val) || (b.val < a.val && b.val < c.val)) {
                if (first == 0) {
                    first = i;
                } else {
                    min = Math.min(min, i - last);
                }
                last = i;
            }
            a = b;
            b = c;
            c = c.next;
        }
        if (first == last) {
            return new int[]{-1, -1};
        }
        return new int[]{min, last - first};
    }
}
