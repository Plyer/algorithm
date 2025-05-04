package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.*;

/**
 * 2368. 受限条件下可到达节点的数目
 *
 * 遍历边 edges 保存到哈希表，使用一个队列保存出发点 0，当队列不为空时：出队一个元素，从哈希表中找到这个元素可到达的点加入队列，此元素加入受限。
 */
public class ReachableNodes {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        int res = 0;
        while (!queue.isEmpty()) {
            Integer num = queue.pollFirst();
            int size = queue.size();
            map.get(num).stream().filter(i -> !set.contains(i)).forEach(queue::add);
            res += queue.size() - size;
            set.add(num);
        }
        return res + 1;
    }
}
