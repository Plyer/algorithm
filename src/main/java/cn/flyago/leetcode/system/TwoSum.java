package cn.flyago.leetcode.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和 为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 *
 * @author Lvjinglu
 * @create 2021/5/28 10:34
 * @since 1.0.0
 */
public class TwoSum {

    /**
     * 双循环暴力求解
     * @param nums
     * @param target
     * @return
     */
    public int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (a + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 把数组转 map，提高查找效率
     * @param nums
     * @param target
     * @return
     */
    public int[] officalSolution(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.officalSolution(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(solution));
        int[] solution2 = twoSum.officalSolution(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(solution2));
        int[] solution3 = twoSum.officalSolution(new int[]{3, 3}, 6);
        System.out.println(Arrays.toString(solution3));
    }
}
