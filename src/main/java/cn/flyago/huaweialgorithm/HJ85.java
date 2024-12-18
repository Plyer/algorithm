package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * HJ85 最长回文子串
 * https://www.nowcoder.com/practice/12e081cd10ee4794a2bd70c7d68f5507?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=85&gioEnter=menu
 */
public class HJ85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res = solve(line);
        System.out.println(res.length());
    }

    private static String solve(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str;
        }

        String res = "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String sub1 = find(chars, i, i);
            String sub2 = find(chars, i, i + 1);
            res = maxStr(res, sub1, sub2);
        }
        return res;
    }

    private static String find(char[] chars, int l, int r) {
        if (l < 0 || r >= chars.length || chars[l] != chars[r]) {
            return "";
        }
        for (; l >= 0 && r < chars.length && chars[l] == chars[r]; l--, r++) {
        }
        l++;
        r--;
        return new String(chars, l, r - l + 1);
    }

    private static String maxStr(String... arr) {
        String res = "";
        for (String str : arr) {
            if (str.length() > res.length()) {
                res = str;
            }
        }
        return res;
    }
}
