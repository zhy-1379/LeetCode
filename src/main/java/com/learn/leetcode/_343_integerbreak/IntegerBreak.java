package com.learn.leetcode._343_integerbreak;

/**
 * ClassName: IntegerBreak
 * Description:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1：
 *      输入: 2
 *      输出: 1
 *      解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *      输入: 10
 *      输出: 36
 *      解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * date: 2020/7/30 20:42
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 100; i++) {
            System.out.println(solution.integerBreak1(i));
        }
    }
}


