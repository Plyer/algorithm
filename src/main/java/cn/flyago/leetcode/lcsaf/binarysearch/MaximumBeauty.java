package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 2070. 每一个查询的最大美丽值
 *
 * 二分查找：根据二维数组的第一列对其进行升序排序，然后遍历第二列把第二列的元素修改为从第二列第一个元素到当前元素的最大值。枚举 queries：使用二分查找到 <=queries[i] 的行，其第二列的值即为最大美丽值。
 */
public class MaximumBeauty {

    int[][] t;

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] res = new int[queries.length];
        t = new int[items.length][];
        sort(items, 0, items.length);
        int max = Integer.MIN_VALUE;
        for (int[] item : items) {
            max = Math.max(max, item[1]);
            item[1] = max;
        }

        for (int i = 0; i < queries.length; i++) {
            int l = 0, r = items.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (items[mid][0] < queries[i] + 1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = r < 0 ? 0 : items[r][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] t = new int[2][];
        t[0] = new int[]{2, 0};
        t[1] = new int[]{1, 0};
        new MaximumBeauty().maximumBeauty(t, null);
    }

    private void sort(int[][] items, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(items, l, mid);
        sort(items, mid, r);
        System.arraycopy(items, l, t, l, r - l);
        int i = l, j = mid, k = l;
        while (i < mid && j < r) {
            if (t[i][0] < t[j][0]) {
                items[k++] = t[i++];
            } else {
                items[k++] = t[j++];
            }
        }
        while (i < mid) {
            items[k++] = t[i++];
        }
        while (j < r) {
            items[k++] = t[j++];
        }
    }
}
