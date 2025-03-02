package cn.flyago.leetcode.base;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
