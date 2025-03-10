package cn.flyago.leetcode.lcsaf.linkedlist;

import cn.flyago.leetcode.base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 *
 * 复制出链表，把新链表的索引和节点保存到哈希表，同时把旧链表的节点和索引保存到哈希表，再次枚举原链表把对应新链表的随机节点通过两个哈希表找到并进行赋值。
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0), p = dummy, cur = head;
        Map<Integer, Node> idx2Node = new HashMap<>();
        Map<Node, Integer> node2Idx = new HashMap<>();
        int i = 0;
        while (cur != null) {
            p.next = new Node(cur.val);
            p = p.next;
            node2Idx.put(cur, i);
            cur = cur.next;
            idx2Node.put(i++, p);
        }

        cur = head;
        p = dummy.next;
        while (cur != null) {
            p.random = cur.random == null ? null : idx2Node.get(node2Idx.get(cur.random));
            cur = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}
