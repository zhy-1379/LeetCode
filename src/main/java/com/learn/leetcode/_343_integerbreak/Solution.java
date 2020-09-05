package com.learn.leetcode._343_integerbreak;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/7/30 20:48
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {

    public long integerBreak1(int n) {
        if (n < 4) {
            return n - 1L;
        }
        int q = n / 3;// 商
        int r = n % 3;// 余数
        long res = 1;
        res *= Math.pow(3, q);
        if (r == 0) {
            return res;
        } else if (r == 1) {
            return res / 3 * 4;
        } else {
            return res * 2;
        }
    }

    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }


}
