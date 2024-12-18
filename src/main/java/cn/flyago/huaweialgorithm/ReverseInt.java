package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * HJ11 数字颠倒
 * https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&tqId=21234&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class ReverseInt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 10) {
            System.out.println(num);
            return;
        }
        StringBuilder result = new StringBuilder();
        for (;num > 0; num /= 10) {
            result.append(num % 10);
        }
        System.out.println(result);
    }
}
