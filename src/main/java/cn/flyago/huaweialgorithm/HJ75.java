package cn.flyago.huaweialgorithm;

/**
 * HJ75 公共子串计算
 * https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=&judgeStatus=&tags=&title=75&gioEnter=menu
 */
public class HJ75 {

    public static void main(String[] args) {
        System.out.println(9.8>9.11);
//        Scanner sc = new Scanner(System.in);
//        String line1 = sc.nextLine();
//        String line2 = sc.nextLine();
//        int res = solve(line1, line2);
//        System.out.println(res);
    }

    private static int solve(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int res = 0;
        int n1 = chars1.length;
        int n2 = chars2.length;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (chars1[i] == chars2[j]) {
                    int cur = 0;
                    for (int x = i, y = j; x < n1 && y < n2 && chars1[x] == chars2[y]; x++, y++) {
                        cur++;
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
}
