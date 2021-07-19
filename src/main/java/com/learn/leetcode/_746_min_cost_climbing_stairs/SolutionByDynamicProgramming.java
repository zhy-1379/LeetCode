package com.learn.leetcode._746_min_cost_climbing_stairs;

/**
 * 动态规划：
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * @author zhy
 */
public class SolutionByDynamicProgramming {

    /**
     * f(n) = min{[f(n-1) + cost(n-1)], [f(n-2) + cost(n-2)]}
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // if (n == 1) {
        //     return cost[0];
        // } else if (n == 2) {
        //     return Math.min(cost[0], cost[1]);
        // }

        int pre2 = 0;
        int pre1 = 0;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = Math.min(pre1 + cost[n - 1], pre2 + cost[n - 2]);
            pre2 = pre1;
            pre1 = fn;
        }
        return fn;
    }

}
