package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 判断s是不是t的子序列
 * t删除部分字符后能变成s，则s是t的子序列。定义两个指针，一个指向s的第一个字符，一个指向s的第一个字符。遍历s，当找到t指针的字符时t指针往右移动，当t字符越界时s是t的子序列。
 */
public class Subsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String t = sc.nextLine();
            System.out.println(subsequence(s, t));
        }
    }

    static boolean subsequence(String s, String t) {
        for (int sp = 0, tp = 0; tp < t.length(); tp++) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            if (sp == s.length()) {
                return true;
            }
        }
        return false;
    }
}
