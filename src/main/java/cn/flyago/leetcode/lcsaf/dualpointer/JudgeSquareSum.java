package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 633. 平方数之和
 *
 * 相向双指针：
 * 1. 对 c 开方，得到开方结果整数 x。
 * 2. 定义左右指针 l=0 r=x，求左右指针平方和 sum，如果 sum=c 得到结果，如果 sum>c r--，否则 l++。直到左右指针相遇（包括）。因为 sum 可能溢出，所以把 sum=c 转换成 l*l=c-r*r。
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        for (int l = 0, r = (int) Math.sqrt(c); l <= r; ) {
            if (l * l == c - r * r) {
                return true;
            } else if (l * l < c - r * r) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }
}
