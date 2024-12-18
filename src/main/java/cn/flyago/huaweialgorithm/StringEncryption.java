package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 字符串加密
 */
public class StringEncryption {

    public static void main(String[] args) {
        int[] offset = new int[49];
        offset[0] = 1;
        offset[1] = 2;
        offset[2] = 4;
        for (int i = 3; i < offset.length; i++) {
            offset[i] = offset[i - 1] + offset[i - 2] + offset[i - 3];
        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            sc.nextLine();
            String[] arr = new String[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextLine();
            }

            for (String s : stringEncryption(arr, offset)) {
                System.out.println(s);
            }
        }
    }

    static String[] stringEncryption(String[] arr, int[] offset) {
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                chars[j] = (char) (chars[j] + offset[j]);
            }
            arr[i] = new String(chars);
        }
        return arr;
    }
}
