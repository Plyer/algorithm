package cn.flyago.leetcode.system;

/**
 * 191 位1的个数
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
