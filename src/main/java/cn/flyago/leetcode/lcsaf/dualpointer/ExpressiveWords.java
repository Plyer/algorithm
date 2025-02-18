package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 809. 情感丰富的文字
 *
 * 双序列双指针
 */
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        out:
        for (String word : words) {
            int i = 0, j = 0;
            int n = s.length(), m = word.length();
            while (i < n && j < m) {
                if (word.charAt(j) != s.charAt(i)) {
                    continue out;
                }
                int a = i, b = j;
                while (a < n && s.charAt(a) == s.charAt(i)) {
                    a++;
                }
                while (b < m && word.charAt(b) == word.charAt(j)) {
                    b++;
                }
                a -= i;
                b -= j;
                if (a < b || (a > b && a < 3)) {
                    continue out;
                }
                i += a;
                j += b;
            }
            if (i == n && j == m) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ExpressiveWords().expressiveWords("heeellooo", new String[]{"helo"}));
    }
}
