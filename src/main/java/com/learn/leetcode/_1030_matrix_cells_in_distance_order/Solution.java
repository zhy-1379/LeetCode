package com.learn.leetcode._1030_matrix_cells_in_distance_order;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/11/17 21:02
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(res, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
        return res;
    }

}
