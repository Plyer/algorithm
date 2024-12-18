package cn.flyago.leetcode.base;

import java.util.ArrayDeque;

public class MonotonicQueue<T extends Comparable<T>> {
    ArrayDeque<T> deque = new ArrayDeque<>();

    public void push(T e) {
        while (!deque.isEmpty() && deque.getLast().compareTo(e) < 0) {
            deque.pollLast();
        }
        deque.addLast(e);
    }

    public T max() {
        return deque.getFirst();
    }

    public void poll(T e) {
        if (deque.peek() != null && e.compareTo(deque.peek()) == 0) {
            deque.poll();
        }
    }
}
