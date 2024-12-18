package cn.flyago.huaweialgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 已知先序遍历和中序遍历，求二叉树的后序遍历 https://www.cnblogs.com/gcter/p/15469584.html
 */
public class BinaryTreeConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            printMidOrder(binaryTreeConstruction(sc.next(), sc.next()));
            System.out.println();
        }
    }

    static void printMidOrder(BinarytreeMidOrder.TreeNode root) {
        if (root == null) {
            return;
        }
        printMidOrder(root.left);
        printMidOrder(root.right);
        System.out.print(root.val);
    }

    static BinarytreeMidOrder.TreeNode binaryTreeConstruction(String pre, String mid) {
        Map<Character, Integer> cache = new HashMap<>(mid.length() / 2 + 1);
        for (int i = 0; i < mid.length(); i++) {
            cache.put(mid.charAt(i), i);
        }
        return binaryTreeConstruction(pre, 0, pre.length() - 1, mid, 0, mid.length() - 1, cache);
    }

    static BinarytreeMidOrder.TreeNode binaryTreeConstruction(String pre, int ps, int pe, String mid, int ms, int me, Map<Character, Integer> cache) {
        if (pe < ps) {
            return null;
        }

        BinarytreeMidOrder.TreeNode root = new BinarytreeMidOrder.TreeNode(pre.charAt(ps));
        Integer index = cache.get(root.val);
        BinarytreeMidOrder.TreeNode left = binaryTreeConstruction(pre, ps + 1, ps + index - ms, mid, ms, index - 1, cache);
        BinarytreeMidOrder.TreeNode right = binaryTreeConstruction(pre, ps + index - ms + 1, ps - ms + me, mid, index + 1, me, cache);
        root.left = left;
        root.right = right;
        return root;
    }
}
