package cn.flyago.leetcode.system.backtrace;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 46 全排列
 */
public class Permute {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(nums, trace, used);
        return res;
    }

    /**
     * 回溯算法
     * @param nums 选择列表，结合 used 来获取待选择的选项
     * @param trace 已选择的路径
     * @param used 已使用的路径
     */
    private void backtrace(int[] nums, LinkedList<Integer> trace, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 跳过已使用的路径
            if (used[i]) {
                continue;
            }
            // 做选择
            trace.add(nums[i]);
            used[i] = true;
            // 子节点回溯
            backtrace(nums, trace, used);
            // 撤销选择
            trace.removeLast();
            used[i] = false;
        }
    }
}
