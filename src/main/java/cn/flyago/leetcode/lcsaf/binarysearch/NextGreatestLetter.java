package cn.flyago.leetcode.lcsaf.binarysearch;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * 二分查找：问题可以转换成寻找 >=x+1。
 */
public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') {
            return letters[0];
        }
        char t = (char) (target + 1);
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if (l == letters.length) {
            return letters[0];
        }
        return letters[l];
    }

    public static void main(String[] args) {
        System.out.println((char) ('a' + 1));
    }
}
