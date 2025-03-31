package cn.flyago.leetcode.lcsaf.binarytree;

import cn.flyago.leetcode.base.TreeNode;

import java.util.*;

/**
 * 2471. 逐层排序二叉树所需的最少操作数目
 *
 * 寻找置换环，每个置换环的交换次数是置换环的长度减一。
 * 寻找置换环算法：选定一个数，使用这个数作为索引去找下一个数，一直循环直到找回第一个选定的数，经过的索引就是一个置换环。
 * 由于值超出了数组长度，还需要离散化：复制数组元素对其进行排序，对原数组的值使用二分算法在排序后的数组里查找到索引，就得到了离散化的数组。
 */
public class MinimumOperations {
    public int minimumOperations(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int res = 0;
        while (!list.isEmpty()) {
            List<TreeNode> nxt = new ArrayList<>();
            int[] a = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                a[i] = node.val;
                if (node.left != null) nxt.add(node.left);
                if (node.right != null) nxt.add(node.right);
            }
            res += getMinSwapCount(a);
            list = nxt;
        }
        return res;
    }

    /**
     * 离散化、置换环
     * @param a
     * @return
     */
    private int getMinSwapCount(int[] a) {
        int[] copy = new int[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        Arrays.sort(copy);
        for (int i = 0; i < a.length; i++) {
            a[i] = search(copy, a[i]);
        }

        int res = 0;
        boolean[] visit = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            if (visit[i]) {
                continue;
            }
            int len = 1;
            for (int x = a[i]; a[x] != a[i]; x = a[x]) {
                len++;
                visit[x] = true;
            }
            res += len - 1;
        }
        return res;
    }

    /**
     * 二分查找
     * @param copy
     * @param i
     * @return
     */
    private int search(int[] copy, int i) {
        int l = 0, r = copy.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (copy[mid] >= i) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

//    private int quickSort(List<Integer> list, int s, int e) {
//        if (e - s <= 1) {
//            return 0;
//        }
//        int[] p = help(list, s, e);
//        int cnt = p[0];
//        cnt += quickSort(list, s, p[1]);
//        cnt += quickSort(list, p[1] + 1, e);
//        return cnt;
//    }
//
//    private int[] help(List<Integer> list, int s, int e) {
//        int cnt = 0;
//        int x = list.get(s);
//        int lt = s; // 循环不变量 (s,lt] 范围的值小于 x，(lt,e) 范围的值大于等于 x。
//        for (int i = s + 1; i < e; i++) {
//            if (list.get(i) < x) {
//                lt++;
//                if (lt != i) {
//                    int t = list.get(lt);
//                    list.set(lt, list.get(i));
//                    list.set(i, t);
//                    cnt++;
//                }
//            }
//        }
//        if (lt != s) {
//            list.set(s, list.get(lt));
//            list.set(lt, x);
//            cnt++;
//        }
//        return new int[]{cnt, lt};
//    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(4, new TreeNode(7), new TreeNode(6)), new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)));
        System.out.println(new MinimumOperations().minimumOperations(node));
    }
}
