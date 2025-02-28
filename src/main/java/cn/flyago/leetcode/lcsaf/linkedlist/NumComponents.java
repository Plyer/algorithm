package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

/**
 * 817. 链表组件
 *
 * 链表：使用计数排序 nums 获得 freq[]，枚举链表，记录当前节点是否在 nums 中 curExist 和前一个节点是否在 nums 中 preExists，如果 !curExist && preExists，res++。跳出循环之后判断如果 curExists==true，res++。
 */
public class NumComponents {
    public int numComponents(ListNode head, int[] nums) {
        int[] freq = new int[10001];
        for (int num : nums) {
            freq[num]++;
        }
        boolean curExists = false, preExists = false;
        int res = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            curExists = freq[cur.val] > 0;
            if (!curExists && preExists) {
                res++;
            }
            preExists = curExists;
        }
        if (curExists) {
            res++;
        }
        return res;
    }
}
