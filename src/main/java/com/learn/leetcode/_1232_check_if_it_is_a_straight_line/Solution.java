package com.learn.leetcode._1232_check_if_it_is_a_straight_line;

import com.learn.utils.LoggerUtils;

public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        double k = ((double) y1 - y0) / (x1 - x0);

        for (int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0];
            int yi = coordinates[i][1];

            if (x1 == x0) {
                if (xi != x0) {
                    return false;
                }
            } else {
                if (((double) yi - y0) / (xi - x0) != k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = new int[][]{
                {0, 0},
                {0, 1},
                {0, -1}
        };

        LoggerUtils.info(Solution.class, new Solution().checkStraightLine(coordinates));

    }

}
