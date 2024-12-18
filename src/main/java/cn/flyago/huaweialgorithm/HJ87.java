package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * HJ87 密码强度等级
 * https://www.nowcoder.com/practice/52d382c2a7164767bca2064c1c9d5361?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=87&gioEnter=menu
 */
public class HJ87 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res = solve(line);
        System.out.println(res);
    }

    private static String solve(String line) {
        char[] chars = line.toCharArray();
        int scnum = 0;
        int bcnum = 0;
        int nnum = 0;
        int snum = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                nnum++;
            } else if (c >= 'a' && c <= 'z') {
                scnum++;
            } else if (c >= 'A' && c <= 'Z') {
                bcnum++;
            } else {
                snum++;
            }
        }

        int score = 0;
        if (chars.length <= 4) {
            score += 5;
        } else if (chars.length <= 7) {
            score += 10;
        } else {
            score += 25;
        }

        if (scnum > 0 && bcnum > 0) {
            score += 20;
        } else if (scnum > 0 || bcnum > 0) {
            score += 10;
        }

        if (nnum == 1) {
            score += 10;
        } else if (nnum > 1) {
            score += 20;
        }

        if (snum == 1) {
            score += 10;
        } else if (snum > 1) {
            score += 25;
        }

        if (scnum > 0 && bcnum > 0 && nnum > 0 && snum > 0) {
            score += 5;
        } else if (scnum + bcnum > 0 && nnum > 0 && snum > 0) {
            score += 3;
        } else if (nnum > 0 && scnum + bcnum > 0) {
            score += 2;
        }

        String res = "";
        if (score >= 90) {
            res = "VERY_SECURE";
        } else if (score >= 80) {
            res = "SECURE";
        } else if (score >= 70) {
            res = "VERY_STRONG";
        } else if (score >= 60) {
            res = "STRONG";
        } else if (score >= 50) {
            res = "AVERAGE";
        } else if (score >= 25) {
            res = "WEAK";
        } else if (score >= 0) {
            res = "VERY_WEAK";
        }
        return res;
    }
}
