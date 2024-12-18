package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 等差数列 2，5，8，11，14。。。。 （从 2 开始的 3 为公差的等差数列） 输出求等差数列前n项和 数据范围：
 * 输入描述:
 * 输入一个正整数n。
 *
 *
 * 输出描述:
 * 输出一个相加后的整数。
 * 示例1
 * 输入
 * 2
 * 输出
 * 7
 * 说明
 * 2+5=7
 * 示例2
 * 输入
 * 275
 * 输出
 * 113575
 * 说明
 * 2+5+...+821+824=113575
 *
 * HJ100 等差数列
 * https://www.nowcoder.com/practice/f792cb014ed0474fb8f53389e7d9c07f?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=100&gioEnter=menu
 */
public class HJ100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int res = solve(count);
        System.out.println(res);
    }

    private static int solve(int count) {
        int res = 2;
        int cur = 2;
        for (int i = 1; i <= count - 1; i++) {
            res += (cur += 3);
        }
        return res;
    }
}
