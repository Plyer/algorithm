package cn.flyago.leetcode.system.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 752 打开转盘锁
 * BFS 通用解法：把整个问题建模成一张图，从起点开始把最近的节点放进队列进行遍历寻找最短路径。
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        LinkedList<String> queue = new LinkedList<>();
        // 记录已访问的节点防止重复访问
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        // 初始序列
        queue.add("0000");
        visited.add("0000");
        // 初始序列转动了0次
        int c = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历同级序列找结果，如果没有结果把下级序列加入队列
            for (int i = 0; i < size; i++) {
                String pop = queue.pop();
                if (deadSet.contains(pop)) {
                    continue;
                }
                if (pop.equals(target)) {
                    return c;
                }
                char[] chars = pop.toCharArray();
                // 转动1次的序列就是每个数字加一或者减一
                for (int j = 0; j < chars.length; j++) {
                    char o = chars[j];
                    int t = Character.digit(o, 10) + 1;
                    if (t == 10) {
                        t = 0;
                    }
                    chars[j] = Character.forDigit(t, 10);
                    String s = new String(chars);
                    // visited用于防止重复加入队列的判断，所以在加入前判断，加入后立即给visited赋值。
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                    t = Character.digit(o, 10) - 1;
                    t = t == -1 ? 9 : t;
                    chars[j] = Character.forDigit(t, 10);
                    s = new String(chars);
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                    chars[j] = o;
                }
            }
            c++;
        }

        return -1;
    }
}
