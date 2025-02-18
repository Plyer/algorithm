package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 2337. 移动片段得到字符串
 *
 */
public class CanChange {
    public boolean canChange(String start, String target) {
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') {
                continue;
            }
            while (target.charAt(j) == '_') {
                j++;
            }
            // 这里有两种情况：
            // 1. 如果当前字符是 L，并且 i<j，因为 start 的 L 无法向右移动，所以无法转换成 target。
            // 2. 如果当前字符是 R，并且 i>j，因为 start 的 R 无法向左移动，所以无法转换成 target。
            if (i != j && ((start.charAt(i) == 'L') == (i < j))) {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        new CanChange().canChange("_L__R__R_","L______RR");
    }
}
