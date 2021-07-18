package com.learn.leetcode._1137_n_th_tribonacci_number;

/**
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 返回第 n 个泰波那契数Tn 的值。
 *
 * @author zhy
 */
public class SolutionByDynamicProgramming {

    public int tribonacci(int n) {
            if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int tn = 0;
        int tn1 = 1;
        int tn2 = 1;
        int tn3 = tn + tn1 + tn2;
        for (int i = 4; i <= n; i++) {
            tn = tn1;
            tn1 = tn2;
            tn2 = tn3;
            tn3 = tn + tn1 + tn2;
        }
        return tn3;
    }

}
