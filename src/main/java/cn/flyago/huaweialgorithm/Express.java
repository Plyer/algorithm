package cn.flyago.huaweialgorithm;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * HJ54 表达式求值
 * https://www.nowcoder.com/practice/9566499a2e1546c0a257e885dfdbf30d?tpId=37&tqId=21277&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
public class Express {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int result = solve(string);
        System.out.println(result);
    }

    private static int solve(String string) {
        if (string.length() == 0) {
            return 0;
        }

        char[] chars = string.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        int curNum = 0;
        char sign = '+';
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                curNum = curNum * 10 + chars[i] - '0';
            } else if (Objects.equals('(', chars[i])) {
                int j = i + 1;
                for (int count = 1; count > 0; j++) {
                    if (chars[j] == '(' ) {
                        count++;
                    } else if (chars[j] == ')' ) {
                        count--;
                    }
                }
                curNum = solve(string.substring(i + 1, j - 1));
                i = j - 1;
            }

            if (!Character.isDigit(chars[i]) || i == chars.length - 1) {
                if (sign == '+' ) {
                    stack.push(curNum);
                } else if (sign == '-' ) {
                    stack.push(-1 * curNum);
                } else if (sign == '*' ) {
                    stack.push(stack.pop() * curNum);
                } else if (sign == '/' ) {
                    stack.push(stack.pop() / curNum);
                }
                sign = chars[i];
                curNum = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
