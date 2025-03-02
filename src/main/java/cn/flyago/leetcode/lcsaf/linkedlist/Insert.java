package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.Node;

/**
 * LCR 029. 循环有序列表的插入
 *
 * 链表插入节点：遍历循环链表一次，找到 <insertVal 的最大值节点，接在它后面，如果不存在那就在过程中找到最大节点的最右边值，接在其后面。
 */
public class Insert {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node n = new Node(insertVal, null);
            n.next = n;
            return n;
        }
        Node cur = head, maxNode = head, targetNode = null;
        while (true) {
            if (cur.val < insertVal) {
                if (targetNode == null || targetNode.val <= cur.val) {
                    targetNode = cur;
                }
            }
            if (cur.val >= maxNode.val) {
                maxNode = cur;
            }
            cur = cur.next;
            if (cur == head) {
                break;
            }
        }

        if (targetNode != null) {
            targetNode.next = new Node(insertVal, targetNode.next);
        } else {
            maxNode.next = new Node(insertVal, maxNode.next);
        }
        return head;
    }
}
