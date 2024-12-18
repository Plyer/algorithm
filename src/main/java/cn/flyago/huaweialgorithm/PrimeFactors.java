package cn.flyago.huaweialgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 质数因子
 */
public class PrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int[] ints = primeFactors(sc.nextInt());
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
        }
    }

    static int[] primeFactors(int num) {
        List<Integer> res = new ArrayList<>();
        double k = Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            while (num % i == 0) {
                res.add(i);
                num /= i;
            }
        }

        if (num != 1) {
            res.add(num);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
