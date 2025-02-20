package cn.flyago.leetcode.lcsaf.binarysearch;

import java.util.Arrays;

/**
 * 2300. 咒语和药水的成功对数
 * <p>
 * 二分查找：对药水进行升序排序，枚举咒语：对于每个咒语 x，求出 success/x 的上界 y，使用二分查找在药水中找到大于等于 y 的索引，当前的成功对数就是药水长度-y。
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long y = success / spell;
            y += Math.min(success % spell, 1);
            if (y > Integer.MAX_VALUE) {
                continue;
            }
            int t = (int) y;
            int l = 0, r = potions.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (potions[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = potions.length - l;
        }
        return res;
    }
}
