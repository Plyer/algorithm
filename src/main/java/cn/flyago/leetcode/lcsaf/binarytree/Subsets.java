package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 回溯三问：
 * 1. 当前操作：选中或不选当前索引 i 所在的数字。
 * 2. 子问题：大于索引 i 的子集。
 * 3. 下一个子问题：大于索引 i+1 的子集。
 */
public class Subsets {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(i + 1, nums);// 不选
        list.add(nums[i]);// 选
        dfs(i + 1, nums);
        list.removeLast();// 恢复现场
    }
}
