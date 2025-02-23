package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3296. 移山所需的最少秒数
 *
 * 最小堆：使用最小堆优先队列保存 n 个数组，每个数组的元素是 [nextWorkTime, delta, base]，nextWorkTime 表示下一次移动高度 1 的时间（包括之前花费的时间），delta 和 base 辅助计算 next。
 */
public class MinNumberOfSeconds {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        PriorityQueue<long[]> queue = new PriorityQueue<>(n, Comparator.comparing(arr -> arr[0]));
        for (int t : workerTimes) {
            queue.add(new long[]{t, t, t});
        }

        long res = 0;
        while (mountainHeight-- > 0) {
            long[] poll = queue.poll();
            long next = poll[0], delta = poll[1], base = poll[2];
            res = next;
            poll[0] = next + delta + base;
            poll[1] = delta + base;
            queue.add(poll);
        }
        return res;
    }
}
