package com.learn.leetcode._509_fibonacci_number;

/**
 * 使用动态规划
 * - F(n)=F(n−1)+F(n−2)
 *
 * @author zhy
 */
public class SolutionByDynamicProgramming {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre2;       // F(n−2)
        int pre1 = 0;   // F(n−1)
        int fn = 1;     // F(n)
        for (int i = 2; i <= n; ++i) {
            pre2 = pre1;
            pre1 = fn;
            fn = pre2 + pre1;   // F(n)=F(n−1)+F(n−2)
        }
        return fn;
    }
}