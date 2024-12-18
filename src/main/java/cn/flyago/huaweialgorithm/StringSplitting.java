package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 字符串分割 https://leetcode.cn/circle/discuss/niKSMZ/
 *
 */
public class StringSplitting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.printf("%d %s\n", k, s);
        System.out.println(stringSplitting(k, s));
    }

    static String stringSplitting(int k, String s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (; i < s.length(); i++) {
            res.append(s.charAt(i));
            if (s.charAt(i) == '-') {
                i++;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int c = 0, sc= 0, bc = 0;
        for (; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '-') {
                continue;
            }
            sb.append(cur);
            if (cur >= 'a' && cur <= 'z') {
                sc++;
            } else if (cur >= 'A' && cur <= 'Z') {
                bc++;
            }
            if (++c == k) {
                if (sc == bc) {
                    res.append(sb);
                } else if (sc > bc) {
                    res.append(sb.toString().toLowerCase());
                } else {
                    res.append(sb.toString().toUpperCase());
                }
                res.append('-');
                c = sc = bc = 0;
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0) {
            if (sc == bc) {
                res.append(sb);
            } else if (sc > bc) {
                res.append(sb.toString().toLowerCase());
            } else {
                res.append(sb.toString().toUpperCase());
            }
        } else if (res.charAt(res.length() - 1) == '-') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
