package cn.flyago.leetcode.system.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * 46 全排列
 * 通过一个多叉树的遍历来实现
 */
public class Permute2 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        help(trace, nums, used);
        return res;
    }

    void help(LinkedList<Integer> trace, int[] nums, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            trace.add(nums[i]);
            used[i] = true;
            help(trace, nums, used);
            trace.removeLast();
            used[i] = false;
        }
    }
}
