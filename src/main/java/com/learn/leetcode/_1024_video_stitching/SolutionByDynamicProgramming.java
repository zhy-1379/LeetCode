package com.learn.leetcode._1024_video_stitching;

import java.util.Arrays;

/**
 * ClassName: SolutionByDynamicProgramming
 * Description:
 * date: 2020/10/24 22:27
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByDynamicProgramming {

    public int videoStitching(int[][] clips, int T) {
        // dp[i] 表示将区间 [0,i) 覆盖所需的最少子区间的数量
        int[] dp = new int[T + 1];
        // 将所有 dp[i] 的初始值设为一个大整数，并将 dp[0]（即空区间）的初始值设为 0
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

}
