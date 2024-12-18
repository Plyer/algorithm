package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 字符串反转：https://www.nowcoder.com/practice/e45e078701ab4e4cb49393ae30f1bb04?tpId=37&tqId=21235&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        if (string.length() == 0) {
            System.out.println(string);
        }

        char[] chars = string.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        System.out.println(result);
    }
}
