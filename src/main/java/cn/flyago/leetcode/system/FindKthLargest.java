package cn.flyago.leetcode.system;

/**
 * 215 数组中的第K个最大元素
 *
 * 利用快速排序，快排过程是找一个基准然后使用双指针把打于基准数的值排到左边，小于基准数的值排到右边，当基准数的索引值为 k-1 时即为题解。
 */
public class FindKthLargest {

    private Integer res;
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return res;
    }

    public void quickSort(int[] nums, int s, int e, int k) {
        if (s > e) {
            return;
        } else if (s == e && s == k - 1) {
            res = nums[s];
            return;
        }

        int temp = nums[s];
        int p = solve(nums, s, e);
        if (p == k - 1) {
            res = temp;
            return;
        }
        quickSort(nums, s, p - 1, k);
        quickSort(nums, p + 1, e, k);
    }

    public int solve(int[] nums, int s, int e) {
        int base = nums[s];
        int l = s, r = e;

        while (l < r) {
            for (; nums[r] <= base && l < r; r--) {}
            for (; nums[l] >= base && l < r; l++) {}

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        nums[s] = nums[l];
        nums[l] = base;
        return l;
    }

    public static void main(String[] args) {
        new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}
