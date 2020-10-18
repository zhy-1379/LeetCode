package com.learn.leetcode._52_n_queens_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/17 17:40
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    public int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    /**
     * @param n              棋盘边长
     * @param row            当前行
     * @param columns        选择的值
     * @param diagonalsLeft  左斜线的值
     * @param diagonalsRight 右斜线的值
     * @return 个数
     */
    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonalsLeft, Set<Integer> diagonalsRight) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int diagonal1 = row - i;
            int diagonal2 = row + i;
            if (!columns.contains(i) && !diagonalsLeft.contains(diagonal1) && !diagonalsRight.contains(diagonal2)) {
                columns.add(i);
                diagonalsLeft.add(diagonal1);
                diagonalsRight.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonalsLeft, diagonalsRight);
                columns.remove(i);
                diagonalsLeft.remove(diagonal1);
                diagonalsRight.remove(diagonal2);
            }
        }
        return count;
    }
}

