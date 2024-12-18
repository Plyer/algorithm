package cn.flyago.leetcode.system.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 51 N皇后
 *
 * 回溯算法：把N皇后所有的选择想象成N叉树，遍历一遍树即对所有的选项都做了确认。
 * 建模：初始化N个长度为N的点字符串表示棋盘，从棋盘第一行开始做选择，每行的每列都可能是皇后，在做选择时判断皇后的位置是否合法，合法的话递归确认下一行的皇后，直到最后一行的末尾。
 */
public class SolveNQueens {

    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> trace = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            trace.add(s.toString());
        }
        backtrace(trace, 0);
        return res;
    }

    /**
     * 给 row 行确定皇后的位置
     * @param trace row 行之前的皇后路径
     * @param row 指定行的选择列表，里面的每一个位置都可能是皇后的位置
     */
    private void backtrace(List<String> trace, int row) {
        if (row == trace.size()) {
            res.add(new ArrayList<>(trace));
            return;
        }

        for (int i = 0; i < trace.size(); i++) {
            if (!isValid(trace, row, i)) {
                continue;
            }
            String curRow = trace.get(row);
            char[] chars = curRow.toCharArray();
            chars[i] = 'Q';
            trace.set(row, new String(chars));
            backtrace(trace, row + 1);
            trace.set(row, curRow);
        }
    }

    /**
     * 验证指定坐标是否可以放皇后
     * @param trace
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(List<String> trace, int row, int col) {
        // 验证同一列是否已有皇后
        for (int i = 0; i < row; i++) {
            if (trace.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 验证左斜对角是否有皇后
        for (int i = row - 1, c = col - 1; i >= 0 && c >= 0; i--, c--) {
            if (trace.get(i).charAt(c) == 'Q') {
                return false;
            }
        }

        // 验证右斜对角是否有皇后
        for (int i = row - 1, c = col + 1; i >= 0 && c < trace.size(); i--, c++) {
            if (trace.get(i).charAt(c) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
