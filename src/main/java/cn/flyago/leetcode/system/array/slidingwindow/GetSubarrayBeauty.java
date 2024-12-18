package cn.flyago.leetcode.system.array.slidingwindow;

/**
 * 2653. 滑动子数组的美丽值
 *
 * 固定滑动窗口算法：因为值域很小，所以使用计数排序求子数组的美丽值。
 */
public class GetSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int Z = 50;
        int[] arrCount = new int[2 * Z + 1];
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            arrCount[nums[i] + Z]++;
            if (i < k - 1) {
                continue;
            }

            int beau = 0;
            for (int j = -50, y = x; j < 0; j++) {
                y -= arrCount[j + Z];
                if (y <= 0) {
                    beau = j;
                    break;
                }
            }

            arrCount[nums[i - k + 1] + Z]--;
            res[i - k + 1] = beau;
        }
        return res;
    }
}
