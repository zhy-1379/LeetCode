package com.learn.leetcode._566_reshape_the_matrix;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/2/17 18:24
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int or = nums.length;
        int oc = nums[0].length;

        if (or * oc != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];

        // for (int i = 0; i < or; i++) {
        //     for (int j = 0; j < oc; j++) {
        //         int idx = i * oc + j;
        //         res[idx / c][idx % c] = nums[i][j];
        //     }
        // }

        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / oc][i % oc];
        }

        return res;
    }

}
