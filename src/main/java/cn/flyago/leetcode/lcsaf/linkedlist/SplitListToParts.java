package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 725. 分隔链表
 *
 * 链表：枚举链表获取长度 n，求 m=n/k，o=n%k，那么前 o 组元素数量是 m+1，剩余 k-o 组元素数量是 m。
 */
public class SplitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        int m = n / k, o = n % k;
        ListNode[] res = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            int c = m;
            if (i < o) {
                c++;
            }
            if (c == 0) {
                res[i] = null;
                continue;
            }
            res[i] = cur;
            for (int j = 0; j < c - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
