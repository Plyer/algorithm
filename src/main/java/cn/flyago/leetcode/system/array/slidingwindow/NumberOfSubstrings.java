package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 1358. 包含所有三种字符的子字符串数目
 *
 * 不定长滑动窗口-越长越合法-res+=left
 *
 * 使用一个数组保存字符数目，使用一个变量 c 保存字符数目等于 1 的数量，当 c==3 时包含所有三种字符，对窗口进行缩减，最后缩减完毕时以 0~left-1 为左边界的字符串都包含三种字符，res+=left，继续滑动窗口直到结尾。
 */
public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int c = 0 , res = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            int cur = ++arr[s.charAt(r) - 'a'];
            if (cur == 1) c++;
            while (c == arr.length) {
                int t = --arr[s.charAt(l++) - 'a'];
                if (t == 0) c--;
            }
            res += l;
        }
        return res;
    }
}
