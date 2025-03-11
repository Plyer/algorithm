package cn.flyago.leetcode.lcsaf.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU 缓存
 *
 * 在 LRU 缓存的基础上，增加一个哈希表用于保存计数对应的最近使用节点。
 */
public class LFUCache {
    private Node dummy = new Node(0, 0, 0);
    private Map<Integer, Node> key2Node = new HashMap<>();
    private Map<Integer, Node> count2FirstNode = new HashMap<>(); // 保存计数对应的最近使用节点
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.val = value;
            return;
        }
        node = new Node(key, value, 1);
        // 如果容量满了，先删除节点
        if (key2Node.size() == capacity) {
            remove4CountMap(dummy.prev);
            key2Node.remove(dummy.prev.key);
            remove(dummy.prev);
        }
        // 把 node 放到 cnt 的头节点之前
        final int cnt = node.cnt;
        Node targetNode = count2FirstNode.get(cnt);
        targetNode = targetNode == null ? dummy : targetNode;
        count2FirstNode.put(cnt, node);
        pushPrev(node, targetNode);
        key2Node.put(key, node);
    }

    private Node getNode(int key) {
        Node node = key2Node.get(key);
        if (node == null) {
            return null;
        }
        // 把 node 放到 cnt+1 的头节点之前
        final int cnt = node.cnt;
        Node targetNode = count2FirstNode.get(cnt + 1);
        if (targetNode == null) {
            // cnt+1 的头节点不存在，那就移动到 cnt 的头节点之前
            targetNode = count2FirstNode.get(cnt);
        }
        remove4CountMap(node);
        count2FirstNode.put(cnt + 1, node);
        if (node != targetNode) {
            remove(node);
            pushPrev(node, targetNode);
        }
        node.cnt++;
        return node;
    }

    private void remove4CountMap(Node node) {
        final int cnt = node.cnt;
        Node cntFirstNode = count2FirstNode.get(cnt);
        if (cntFirstNode != node) {
            return;
        }
        if (node.next.cnt == cnt) {
            count2FirstNode.put(cnt, node.next);
        } else {
            count2FirstNode.remove(cnt);
        }
    }

    /**
     * 把 node 连接到 target 节点之前
     * @param node
     * @param target
     */
    private void pushPrev(Node node, Node target) {
        node.prev = target.prev;
        node.next = target;
        node.prev.next = node;
        node.next.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static class Node {
        int key, val;
        int cnt = 1;
        Node prev, next;

        public Node(int key, int val, int cnt) {
            this.key = key;
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
