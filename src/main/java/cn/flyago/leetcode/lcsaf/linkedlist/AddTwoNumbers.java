package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 2. 两数相加
 *
 * 定义 p1=l1 p2=l2 进位c=0，当 p1!=null||p2!=null 时进入循环：对指针所在的值和 c 求和 sum，sum/10 sum%10，取余得到的值就是当前这一位的相加值，除法得到的值作为下一个进位。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(), p = dummy;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        return dummy.next;
    }
}
