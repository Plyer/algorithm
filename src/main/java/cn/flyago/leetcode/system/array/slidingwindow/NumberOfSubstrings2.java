package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 3325. 字符至少出现 K 次的子字符串 I
 *
 * 不定长滑动窗口算法-越长越合法：使用数组记录窗口元素数量，使用 c 记录数组最大值，当 c==k 时缩减窗口，缩减结束更新结果 res+=left。
 */
public class NumberOfSubstrings2 {
    public int numberOfSubstrings(String s, int k) {
        int[] arr = new int[26];
        int res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            int cur = ++arr[s.charAt(r) - 'a'];
            while (cur == k) {
                if (--arr[s.charAt(l++) - 'a'] == cur - 1) {
                    break;
                }
            }
            res += l;
        }
        return res;
    }
}
