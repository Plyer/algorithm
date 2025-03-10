package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.ListNode;

import java.util.Arrays;
import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

/**
 * 382. 链表随机节点
 */
public class Solution {

    int[] arr;

    public Solution(ListNode head) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        arr = new int[n];
        n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            arr[n++] = cur.val;
        }
    }

    public int getRandom() {
        int i = ThreadLocalRandom.current().nextInt(arr.length);
        return arr[i];
    }
}
