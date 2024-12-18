package cn.flyago.leetcode.system.backtrace;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens2 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>(n);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(".");
        }
        for (int i = 0; i < n; i++) {
            board.add(s.toString());
        }
        help(board, 0);
        return res;
    }

    void help(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        char[] chars = board.get(row).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!valid(board, row, i)) {
                continue;
            }
            chars[i] = 'Q';
            board.set(row, new String(chars));
            help(board, row + 1);
            chars[i] = '.';
            board.set(row, new String(chars));
        }
    }

    boolean valid(List<String> board, int x, int y) {
        // 确认同一列是否有皇后
        for (int i = 0; i < board.size() && i < x; i++) {
            if (board.get(i).charAt(y) == 'Q') {
                return false;
            }
        }
        // 确认左斜上是否有皇后
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 确认右斜上是否有皇后
        for (int i = x - 1, j = y + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
