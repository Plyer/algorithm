package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 整数对最小和 https://www.bilibili.com/read/cv26227530/
 */
public class MinSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            int[] a = new int[num];
            for (int i = 0; i < num; i++) {
                a[i] = sc.nextInt();
            }
            num = sc.nextInt();
            int[] b = new int[num];
            for (int i = 0; i < num; i++) {
                b[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            System.out.println(minSum(a, b, k));
        }
    }

    static int minSum(int[] a, int[] b, int k) {
        int sum = a[0] + b[0];
        for (int i = 0, j = 0, c = 1; c < k; c++) {
            if (i + 1 == a.length) {
                sum += a[i] + b[++j];
                continue;
            }
            if (j + 1 == b.length) {
                sum += a[++i] + b[j];
                continue;
            }

            if (a[i] + b[j + 1] > a[i + 1] + b[j]) {
                sum += a[++i] + b[j];
            } else {
                sum += a[i] + b[++j];
            }
        }
        return sum;
    }
}
