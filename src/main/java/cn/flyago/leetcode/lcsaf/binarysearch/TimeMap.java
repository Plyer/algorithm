package cn.flyago.leetcode.lcsaf.binarysearch;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. 基于时间的键值存储
 *
 * 二分查找：使用 Map<String, List<Map<Integer, String>>> 来保存，根据题意 List 中 map 的时间戳一定严格递增，可以使用二分查找来找到 <=t 的最大索引。
 */
public class TimeMap {

    static class Node {
        int t;
        String v;

        public Node(int t, String v) {
            this.t = t;
            this.v = v;
        }
    }

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null) {
            return "";
        }
        int l = 0, r = nodes.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nodes.get(mid).t < timestamp + 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r >= 0 ? nodes.get(r).v : "";
    }
}
