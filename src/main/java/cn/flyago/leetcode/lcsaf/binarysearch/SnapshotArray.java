package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 1146. 快照数组
 *
 * 二分查找：List<List<Node>>，子数组保存初始化快照号和值，get 在子数组中使用二分查找找到小于等于快照号对应的最大快照号的值。
 *
 */
public class SnapshotArray {

    static class Node {
        int snapId;
        int value;

        public Node(int snapId, int value) {
            this.snapId = snapId;
            this.value = value;
        }
    }
    List<List<Node>> lists;
    int nextSnapId = 0;
    public SnapshotArray(int length) {
        lists = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            lists.add(null);
        }
    }

    public void set(int index, int val) {
        List<Node> nodes = lists.get(index);
        if (nodes == null) {
            nodes = new ArrayList<>();
            lists.set(index, nodes);
        }
        nodes.add(new Node(nextSnapId, val));
    }

    public int snap() {
        return nextSnapId++;
    }

    public int get(int index, int snap_id) {
        if (index < 0 || index >= lists.size() || snap_id < 0 || snap_id >= nextSnapId) {
            return 0;
        }
        List<Node> nodes = lists.get(index);
        if (nodes == null) {
            return 0;
        }
        int l = 0, r = nodes.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nodes.get(mid).snapId < snap_id + 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r < 0 ? 0 : nodes.get(r).value;
    }

    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(3);
        s.set(0, 5);
        s.snap();
        s.set(0, 6);
        s.get(0, 0);
    }
}
