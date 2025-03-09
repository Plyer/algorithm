package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

import java.util.ArrayDeque;

/**
 * 1019. 链表中的下一个更大节点
 *
 * 反转链表后进行枚举：使用底大顶小的单调栈保存当前节点之前节点的值，在栈顶寻找大于当前节点值的值，没找到则弹出，最后把当前节点值压进栈里。
 */
public class NextLargerNodes2 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode pre = null, cur = head, nxt = null;
        int n = 0;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            n++;
        }

        int[] res = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        while (pre != null) {
            while (!st.isEmpty() && st.peek() <= pre.val) {
                st.pop();
            }
            res[--n] = st.isEmpty() ? 0 : st.peek();
            st.push(pre.val);
            pre = pre.next;
        }
        return res;
    }
}
