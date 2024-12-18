package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 求满足条件的最长子串的长度 https://www.jianshu.com/p/edc1efd18a67
 */
public class MaxSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(maxSubString(sc.nextLine()));
        }
    }

    static int maxSubString(String s) {
        int l = 0, r = 0, rl = -1, rr = -2, count = 0;
        for (; r < s.length(); r++) {
            if (Character.isLetter(s.charAt(r))) {
                count++;
                // 缩减窗口
                while (count > 1) {
                    if (Character.isLetter(s.charAt(l++))) {
                        count--;
                    }
                }
                // 缩减窗口之后字母数量一定为 1，保存结果
                if (r - l > rr - rl) {
                    rr = r;
                    rl = l;
                }
            }
        }
        if (rl == -1) {
            return -1;
        } else {
            return rr - rl + 1;
        }
    }
}
