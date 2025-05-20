package cn.flyago.leetcode.lcsaf.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1286. 字母组合迭代器
 *
 * 子集型回溯。
 */
public class CombinationIterator {
    List<String> list = new ArrayList<>();
    String characters;
    char[] path;
    int n;
    int idx;
    public CombinationIterator(String characters, int combinationLength) {
        this.characters= characters;
        this.n = combinationLength;
        path = new char[n];
        dfs(0, 0);
    }

    public String next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }

    /**
     *
     * @param i characters 的索引
     * @param pathIdx 路径的索引
     */
    private void dfs(int i, int pathIdx) {
        if (pathIdx == n) {
            list.add(new String(path));
            return;
        }
        if (i == characters.length()) return;
        // 选中 characters.charAt(i)
        path[pathIdx] = characters.charAt(i);
        dfs(i + 1, pathIdx + 1);
        // 不选
        dfs(i + 1, pathIdx);
    }
}
