package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 2516. 每种字符至少取 K 个
 *
 * 问题可以转换为求每种字符至多取『原始字符个数-K』个的最大子串。
 *
 * 1. 遍历一次字符串获取每种字符个数，如果某个个数小于 K 则无法取到返回 -1。
 * 2. 计算『原始字符个数-K』，在窗口中对这个数进行递减，当这个数小于0时缩减窗口，保存子串长度。
 */
public class TakeCharacters {
    public int takeCharacters(String s, int k) {
        int[] counts = new int[3];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < counts.length; i++) {
            counts[i] -= k;
            if (counts[i] < 0) {
                return -1;
            }
        }

        int max = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            int i = s.charAt(r) - 'a';
            counts[i]--;
            while (counts[i] < 0) {
                counts[s.charAt(l++) - 'a']++;
            }
            max = Math.max(max, r - l + 1);
        }

        return s.length() - max;
    }
}
