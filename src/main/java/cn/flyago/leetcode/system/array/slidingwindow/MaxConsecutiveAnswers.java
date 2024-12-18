package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 2024. 考试的最大困扰度
 *
 * 不定长滑动窗口算法：在窗口中分别计算T和F的数量tc fc，当 min(tc,fc)<=k 则子串满足要求，记录最长子串长度。
 */
public class MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0, tc = 0, fc = 0;
        for (int l = 0, r = 0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r) == 'F') {
                fc++;
            } else {
                tc++;
            }
            while (Math.min(tc, fc) > k) {
                if (answerKey.charAt(l) == 'F') {
                    fc--;
                } else {
                    tc--;
                }
                l++;
            }
            res = Math.max(res, tc + fc);
        }
        return res;
    }
}
