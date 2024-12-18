package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 字符串最小和 https://www.nowcoder.com/discuss/663146105709867008
 */
public class StringMinSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(stringMinSum(sc.nextLine()));
        }
    }

    static int stringMinSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 处理负数
            if (c == '-') {
                StringBuilder sb = new StringBuilder();
                for (i++; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    sb.append(s.charAt(i));
                }
                sum -= sb.length() > 0 ? Integer.parseInt(sb.toString()) : 0;
                i--;
                continue;
            }

            if (Character.isDigit(c)) {
                sum += Character.digit(c, 10);
            }
        }
        return sum;
    }
}
