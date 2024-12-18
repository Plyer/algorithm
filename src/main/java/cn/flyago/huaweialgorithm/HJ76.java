package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。 例如： 1^3=1 2^3=3+5 3^3=7+9+11 4^3=13+15+17+19 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。 数据范围： 进阶：时间复杂度：，空间复杂度：
 * 输入描述:
 * 输入一个int整数
 *
 *
 * 输出描述:
 * 输出分解后的string
 * 示例1
 * 输入
 * 6
 * 输出
 * 31+33+35+37+39+41
 *
 * HJ76 尼科彻斯定理
 * https://www.nowcoder.com/practice/dbace3a5b3c4480e86ee3277f3fe1e85?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=76&gioEnter=menu
 */
public class HJ76 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = solve(num);
        System.out.println(res);
    }

    private static String solve(int num) {
        if (num == 1) {
            return "1";
        }

        int mid = num * num;
        StringBuilder res = new StringBuilder();
        int left, right;
        if (mid % 2 == 0) {
            left = mid - 1;
            right = mid + 1;
            res.append(left);
            res.append("+");
            res.append(right);
        } else {
            res.append(mid);
            left = mid;
            right = mid;
        }
        for (int count = 2; count < num; count += 2) {
            res.insert(0, (left -= 2) + "+");
            res.append("+");
            res.append(right += 2);
        }
        return res.toString();
    }
}
