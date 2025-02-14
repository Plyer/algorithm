package cn.flyago.leetcode.lcsaf.dualpointer;

/**
 * 1089. 复写零
 *
 * 双指针：复制数组，一个指针 i 指向副本数组 copy，一个指针 j 指向原数组，枚举副本数组指针（同时移动指针 j）：使用副本数组对原数组进行赋值 arr[j]=copy[i]，当 copy[i]==0 时，如果 ++j 未越界则 arr[j]=0。
 */
public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        for (int i = 0, j = 0; j < arr.length; i++, j++) {
            arr[j] = copy[i];
            if (copy[i] == 0 && ++j < arr.length) {
                arr[j] = 0;
            }
        }
    }
}
