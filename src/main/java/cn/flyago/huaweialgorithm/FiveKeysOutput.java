package cn.flyago.huaweialgorithm;

import java.util.Scanner;

/**
 * 5键键盘的输出 https://blog.nowcoder.net/n/c7bb482cddb647b5965c2f55ef13f7da
 * 定义3个数据结构分别保存屏幕输出、剪贴板、选中状态，遍历输入对上述结构进行修改。
 */
public class FiveKeysOutput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int[] input = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                input[i] = Integer.parseInt(s[i]);
            }
            System.out.println(new FiveKeysOutput().fiveKeysOutput(input));
        }
    }

    // 数字 12345代表 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a五个键的输入
    public int fiveKeysOutput(int[] input) {
        boolean selected = false;
        int screen = 0;
        int clipboard = 0;
        for (int i : input) {
            switch (i) {
                case 1:// 输入a
                    if (selected) {
                        screen = 1;
                    } else {
                        screen++;
                    }
                    selected = false;
                    break;
                case 2:// ctrl-c
                    if (selected) {
                        clipboard = screen;
                    }
                    break;
                case 3:// ctrl-x
                    if (selected) {
                        clipboard = screen;
                        screen = 0;
                        selected = false;
                    }
                    break;
                case 4:// ctrl-v
                    if (selected) {
                        screen = clipboard;
                    } else {
                        screen += clipboard;
                    }
                    selected = false;
                case 5: // ctrl-a
                    if (screen > 0) {
                        selected = true;
                    }
                default:
            }
        }
        return screen;
    }
}
