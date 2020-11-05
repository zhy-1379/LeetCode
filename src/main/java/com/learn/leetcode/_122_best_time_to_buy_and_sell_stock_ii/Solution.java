package com.learn.leetcode._122_best_time_to_buy_and_sell_stock_ii;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            if (sub > 0) {
                res += sub;
            }
        }

        return res;
    }

}
