package cn.flyago.leetcode.lcsaf.linkedlist;

/**
 * 707. 设计链表
 */
public class MyLinkedList {

    private static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head, tail;
    private int size;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node p = head;
        for (int i = 1; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);
        size++;
        tail = tail == null ? head : tail;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val, null);
        } else {
            tail.next = new Node(val, null);
            tail = tail.next;
        }
        size++;
        head = head == null ? tail : head;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        Node p = new Node(0, head);
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = new Node(val, p.next);
        size++;

        if (size == 1) {
            head = p.next;
            tail = p.next;
        } else if (index == 0) {
            head = p.next;
        } else if (index == size - 1) {
            tail = p.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node p = new Node(0, head);
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;

        if (size == 0) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = p.next;
        } else if (index == size) {
            tail = p;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}
