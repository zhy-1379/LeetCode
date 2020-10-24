package com.learn.leetcode._1024_video_stitching;

/**
 * ClassName: SolutionByGreedyAlgorithm
 * Description:
 * date: 2020/10/24 22:44
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByGreedyAlgorithm {

    public int videoStitching(int[][] clips, int T) {
        int[] maxEnds = new int[T];
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxEnds[clip[0]] = Math.max(maxEnds[clip[0]], clip[1]);
            }
        }

        int end = 0;
        int res = 0;
        int start = 0;
        for (int i = 0; i < T; i++) {
            end = Math.max(end, maxEnds[i]);
            if (i == end) {
                return -1;
            }
            if (i == start) {
                res++;
                start = end;
            }
        }
        return res;
    }
}
