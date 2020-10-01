package com.learn.leetcode._19_uibdoe;

/**
 * ClassName: Solution
 * Description:
 * https://leetcode-cn.com/problems/UlBDOe/submissions/
 * date: 2020/10/1 20:51
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    // 动态规划
    public int minimumOperations(String leaves) {
        int len = leaves.length();
        // 对于r*y*r* 的状态表示为：
        //      0 表示 第一个 r*
        //      1 表示 y*
        //      2 表示 第二个 r*
        // 状态函数 stateFun[i][j] 表示对于第 0 片到第 i 片叶子进行调整操作，并且第 i 片叶子处于状态 j 时的最小操作次数
        int[][] stateFun = new int[len][3];

        // len >= 3
        stateFun[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        // 由于会比较最小值, 初始化为 Integer.MAX_VALUE
        stateFun[0][1] = stateFun[0][2] = stateFun[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            // 计算第 0 - i 个字符达到的各个状态需要的操作次数
            boolean isRead = leaves.charAt(i) == 'r';
            // 状态为 0：使所有值为 r
            stateFun[i][0] = stateFun[i - 1][0] + (isRead ? 0 : 1);
            // 状态为 1：使 i 为 y, 0 - i-1 取 状态 0 或 1 的最小次数
            stateFun[i][1] = Math.min(stateFun[i - 1][0], stateFun[i - 1][1]) + (isRead ? 1 : 0);
            if (i > 1) {
                // 状态为 2：使 i 为 r, 要保证中间有 y，所以 0 - i-1 取 状态 为 1 或 2 的最小次数
                stateFun[i][2] = Math.min(stateFun[i - 1][1], stateFun[i - 1][2]) + (isRead ? 0 : 1);
            }
        }

        return stateFun[len - 1][2];
    }
}
