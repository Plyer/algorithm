package cn.flyago.leetcode.system.linkedlists;

import cn.flyago.leetcode.base.ListNode;

/**
 * 19 删除链表的倒数第 N 个节点
 */
public class RemoveNthFromEnd {

    /**
     * 思路：找到倒数第 N+1 个节点 p，执行 p.next = p.next.next 即可。
     * 方法：左右指针法，当右指针走到末尾的 Null时倒数第 N+1 个节点跟右指针距离 N+1 步，所以左右指针需要间隔 N+1 步。
     *      又由于 N+1 最大值为链表长度+1，所以配置一个虚拟头节点防止越界。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = dummy;
        while (n-- > -1) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }
}
