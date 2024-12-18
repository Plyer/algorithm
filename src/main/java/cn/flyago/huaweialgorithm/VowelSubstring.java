package cn.flyago.huaweialgorithm;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 最长的指定瑕疵度的元音子串 https://www.icode9.com/content-1-1259108.html
 */
public class VowelSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int blemish = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(vowelSubstring(s, blemish));
        }
    }

    static int vowelSubstring(String s, int blemish) {
        Set<Character> set = new HashSet<>();
        Collections.addAll(set, 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int l = 0, rl = -1, rr = -2, count = 0;
        for (int r = 0; r < s.length(); r++) {
            // 左指针必须是元音
            for (; l < s.length() && !set.contains(s.charAt(l)); l++) {}
            if (l == s.length()) {
                break;
            }
            r = Math.max(l, r);
            if (!set.contains(s.charAt(r))) {
                count++;
                if (count > blemish) {
                    l = r + 1;
                    count = 0;
                    continue;
                }
            } else if (count == blemish && r - l > rr - rl) {
                rr = r;
                rl = l;
            }
        }

        if (rl == -1) {
            return 0;
        }
        return rr - rl + 1;
    }
}
