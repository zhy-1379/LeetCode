package com.learn.leetcode._70_climbing_stairs;

/**
 * 动态规划
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * @author zhy
 */
public class SolutionByDynamicProgramming {

    /**
     * 最后一次可以爬 1 或 2 个台阶；
     * 因此 f(n) = f(n-1) + f(n-2)
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int f1 = 1;
        int f2 = 2;
        int fn = f1 + f2;
        for (int i = 4; i <= n; i++) {
            f1 = f2;
            f2 = fn;
            fn = f1 + f2;
        }
        return fn;
    }

}
