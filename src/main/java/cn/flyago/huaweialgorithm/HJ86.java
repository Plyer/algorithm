package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1 数据范围：数据组数：， 进阶：时间复杂度：，空间复杂度：
 * 输入描述:
 * 输入一个int类型数字
 *
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 * 示例1
 * 输入
 * 200
 * 输出
 * 2
 * 说明
 * 200的二进制表示是11001000，最多有2个连续的1。
 *
 * HJ86 求最大连续bit数
 * https://www.nowcoder.com/practice/4b1658fd8ffb4217bc3b7e85a38cfaf2?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=86&gioEnter=menu
 */
public class HJ86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = solve2(num);
        System.out.println(res);
    }

    private static int solve(int num) {
        char[] chars = Integer.toBinaryString(num).toCharArray();
        int count = 0;
        int res = 0;
        for (char c : chars) {
            boolean curOneBit = c == '1';
            if (curOneBit) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }

    private static int solve2(int num) {
        int res = 0;
        for (int count = 0; num != 0; num >>>= 1) {
            if ((num & 1) == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
