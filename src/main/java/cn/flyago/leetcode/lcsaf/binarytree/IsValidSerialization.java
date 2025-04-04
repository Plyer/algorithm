package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayDeque;

/**
 * 331. 验证二叉树的前序序列化
 *
 * 遍历前序，使用栈来保存元素，当连续遇到两个 # 时意味着遇到叶子节点，把整个叶子节点变成 #。遍历结束后，如果是二叉树，栈最后只会剩下 #。
 */
public class IsValidSerialization {

    // 优化
    public boolean isValidSerialization2(String preorder) {
        String[] arr = preorder.split(",");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : arr) {
            while (s.equals("#") && "#".equals(stack.peek())) {
                stack.pop();
                if (stack.peek() == null || "#".equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }

    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("#")) {
                if ("#".equals(stack.peek())) {
                    stack.pop();
                    if (stack.peek() == null || stack.peek().equals("#")) {
                        return false;
                    }
                    stack.pop();
                    i--;
                    continue;
                }
            }
            stack.push(arr[i]);
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }

    public static void main(String[] args) {
        new IsValidSerialization().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
