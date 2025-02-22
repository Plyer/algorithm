package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 3296. 移山所需的最少秒数
 *
 * check 函数不对，使用堆排序更好解决。
 *
 * 二分查找：秒数越多，可移的山越高，符合单调性，可以使用二分。
 * 1. 秒数的范围，最小是 1，最大是高度为 10^5，仅有一个工人且时间是 10^6，最大秒数就是 10^6 + 10^6*2 + ... + 10^6*10^5。
 * 2. check 函数：a=mountainHeight/n b=mountainHeight%n，升序排序 workTimes，前 b 个工人需要降低 a+1 的高度，剩余工人需要降低 a 的高度，枚举 workTimes 把所有工时求和，如果和小于等于传入的秒数则符合要求。
 */
//public class MinNumberOfSeconds {
//    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
//        Arrays.sort(workerTimes);
//        long maxHeight = time(1000000, 100000);
//        long l = 1, r = maxHeight;
//        while (l <= r) {
//            long mid = l + (r - l) / 2;
//            if (check(mountainHeight, workerTimes, mid)) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l > maxHeight ? -1 : l;
//    }
//
//    private boolean check(int mountainHeight, int[] workerTimes, long m) {
//        int n = workerTimes.length;
//        int a = mountainHeight / n;
//        int b = mountainHeight % n;
//        long sum = 0;
//        for (int i = 0; i < workerTimes.length; i++) {
//            int height = a;
//            if (i < b) {
//                height++;
//            }
//            sum += time(workerTimes[i], height);
//            if (sum > m) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private long time(int workerTime, int mountainHeight) {
//        long c = (long) ((long) (1 + mountainHeight) * mountainHeight / (double) 2);
//        return workerTime * c;
//    }
//}
