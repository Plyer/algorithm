package cn.flyago.huaweialgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraySplicing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int k = sc.nextInt();
            int num = sc.nextInt();
            String line = sc.nextLine();
            int[][] arr = new int[num][];
            for (int i = 0; i < num; i++) {
                String[] split = sc.nextLine().split(",");
                arr[i] = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            }
            System.out.println(Arrays.toString(arraySplicing(arr, k)));
        }
    }

    static int[] arraySplicing(int[][] arr, int k) {
        List<Integer> res = new ArrayList<>();
        int[] indexes = new int[arr.length];
        int count = 0, i = 0;
        while (count < arr.length) {
            if (indexes[i] >= arr[i].length) {
                continue;
            }
            int j = indexes[i];
            for (int e = j + k; j < e; j++) {
                if (j == arr[i].length) {
                    count++;
                    break;
                }
                res.add(arr[i][j]);
            }
            indexes[i] = j;
            if (++i == arr.length) {
                i = 0;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
