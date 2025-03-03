package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;
import cn.flyago.leetcode.lcsaf.slidingwindow.FindAnagrams;

/**
 * 1721. 交换链表中的节点
 *
 * 前后指针：找到正数第 K 个和倒数第 K 个节点的前驱节点，然后做交换。
 */
public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), cur = dummy;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        ListNode fi = cur, se = dummy;
        cur = cur.next;
        boolean meet = false;
        while (cur.next != null) {
            if (se == fi) {
                meet = true;
            }
            cur = cur.next;
            se = se.next;
        }

        // 确保 fi 在 se 之前或相等
        if (!meet) {
            ListNode t = fi;
            fi = se;
            se = t;
        }

        // 如果两个待交换节点相邻则使用反转链表的方式来交换
        if (fi.next.next == se.next) {
            ListNode pre = null;
            cur = fi.next;
            for (int i = 0; i < 2; i++) {
                ListNode t = cur.next;
                cur.next = pre;
                pre = cur;
                cur = t;
            }
            ListNode fiNxt = fi.next;
            fi.next = pre;
            fiNxt.next = cur;
            return dummy.next;
        }
        // 交换 fi.next 和 se.next
        ListNode fiNxt = fi.next, seNxtNxt = se.next.next;
        fi.next = se.next;
        se.next.next = fiNxt.next;
        se.next = fiNxt;
        fiNxt.next = seNxtNxt;
        return dummy.next;
    }

    public static void main(String[] args) {
        new SwapNodes().swapNodes(new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5)))))))))), 5);
    }
}
