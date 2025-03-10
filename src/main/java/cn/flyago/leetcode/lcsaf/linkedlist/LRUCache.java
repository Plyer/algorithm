package cn.flyago.leetcode.lcsaf.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 *
 * 使用双向链表保存数据，头部保存最近操作过的值，使用哈希表保存 key 对应的节点。
 * 创建双向链表时使用一个虚拟节点可以使所有节点的 prev 和 next 都不为空，消除方法实现过程中的判空逻辑。
 */
public class LRUCache {

    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> key2Node = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.next = dummy;
        dummy.prev = dummy;
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
        node = new Node(key, value);
        key2Node.put(key, node);
        pushFirst(node);
        if (key2Node.size() > capacity) {
            key2Node.remove(dummy.prev.key);
            remove(dummy.prev);
        }
    }

    /**
     * 获取节点并把节点放到头部
     * @param key
     * @return
     */
    private Node getNode(int key) {
        Node node = key2Node.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        pushFirst(node);
        return node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void pushFirst(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }
}
