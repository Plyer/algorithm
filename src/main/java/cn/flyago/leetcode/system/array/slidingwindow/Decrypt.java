package cn.flyago.leetcode.system.array.slidingwindow;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 * <p>
 * 定长滑动窗口算法：求长度为K的窗口元素和 sum，如果 k>0，res[i-k+n%n]=sum；如果 k<0，res[i+1%n]=sum。遍历结尾是 i<len+k
 */
public class Decrypt {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int n = code.length;
        int[] res = new int[n];
        int sum = 0;
        int absK = Math.abs(k);
        for (int i = 0; i < n + absK; i++) {
            sum += code[i % n];
            if (i < absK - 1) {
                continue;
            }
            if (k > 0) {
                res[(i - k + n) % n] = sum;
            } else {
                res[(i + 1) % n] = sum;
            }
            sum -= code[(i - absK + 1) % n];
        }
        return res;
    }
}
