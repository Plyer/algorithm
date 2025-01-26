package cn.flyago.leetcode.lcsaf.dualpointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 *
 * 相向双指针：
 * 1. 数组升序排序，定义左右指针 l=0 r=n-1
 * 2. 求左右指针元素和 sum，如果 sum<target，以 l 为下标对第一个元素的合法元组有 r-l 个，l++；如果 sum>=target，r 左移直到不同的元素。当 l<r 时重复上述操作。
 */
public class CountPairs {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for (int l = 0, r = nums.size() - 1; l < r; ) {
            int sum = nums.get(l) + nums.get(r);
            if (sum < target) {
                res += r - l;
                l++;
            } else {
                for (r--; r > l && nums.get(r) == nums.get(r + 1); r--) {}
            }
        }
        return res;
    }
}
