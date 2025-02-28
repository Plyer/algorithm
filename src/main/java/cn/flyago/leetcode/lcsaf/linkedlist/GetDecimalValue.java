package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 1290. 二进制链表转整数
 *
 * 链表：枚举链表，对之前已保存的结果使用位运算左移一位，然后跟当前值做或运算。
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res |= head.val;
            head = head.next;
        }
        return res;
    }
}
