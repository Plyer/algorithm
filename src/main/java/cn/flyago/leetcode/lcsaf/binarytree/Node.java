package cn.flyago.leetcode.lcsaf.binarytree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
    }
}
