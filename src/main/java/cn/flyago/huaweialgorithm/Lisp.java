package cn.flyago.huaweialgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 仿LISP运算 https://www.bilibili.com/read/cv27067753/
 */
public class Lisp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] lisp = lisp(sc.nextLine(), 0);
            if (lisp == null) {
                System.out.println("error");
            } else {
                System.out.println(lisp[0]);
            }
        }
    }

    static int[] lisp(String exp, int startIndex) {
        String op = exp.substring(startIndex + 1, startIndex + 4);
        List<Integer> nums = new ArrayList<>();
        int i = startIndex + 5;
        for (; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                int[] lisp = lisp(exp, i);
                nums.add(lisp[0]);
                i = lisp[1] + 1;
                continue;
            }
            StringBuilder num = new StringBuilder();
            while (c != ' ' && c != ')') {
                num.append(c);
                c = exp.charAt(++i);
            }
            nums.add(Integer.parseInt(num.toString()));
            if (c == ')') {
                break;
            }
        }

        switch (op) {
            case "add": return new int[]{nums.get(0) + nums.get(1), i};
            case "sub": return new int[]{nums.get(0) - nums.get(1), i};
            case "mul": return new int[]{nums.get(0) * nums.get(1), i};
            case "div":
                if (nums.get(1) == 0) {
                    return null;
                }
                return new int[]{nums.get(0) / nums.get(1), i};
            default:
                return null;
        }
    }
}
