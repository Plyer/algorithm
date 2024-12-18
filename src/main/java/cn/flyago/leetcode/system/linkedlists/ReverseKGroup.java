package cn.flyago.leetcode.system.linkedlists;


import cn.flyago.leetcode.base.ListNode;

/**
 * 25 K 个一组翻转链表
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode[] reversed = reverse(head, k);
        ListNode res = reversed[0], p = reversed[1], tail = head;
        // 翻转后第k+1个节点(变量p)为空就表示到了末尾。
        while (p != null) {
            ListNode[] nodes = reverse(p, k);
            tail.next = nodes[0];// 连接翻转后的链表
            tail = p;// 传入reverse函数的的链表头执行后变成尾部
            p = nodes[1];
        }
        return res;
    }

    /**
     * 翻转链表的前K个节点，如果链表长度<k，恢复成原链表
     * @return 返回数组，第一个元素为翻转后的头节点，第二个元素为原始链表的 k+1 节点。
     */
    ListNode[] reverse(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode left = head, right = head.next;
        left.next = null;
        int z = k;
        z--;
        while (right != null && z > 0) {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
            z--;
        }

        // 链表长度<k,恢复成原链表
        if (z > 0) {
            return reverse(left, k - z);
        }
        return new ListNode[]{left, right};
    }
}
