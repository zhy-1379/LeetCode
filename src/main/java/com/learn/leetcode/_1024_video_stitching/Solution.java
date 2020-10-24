package com.learn.leetcode._1024_video_stitching;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/24 21:12
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int videoStitching(int[][] clips, int T) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < clips.length; i++) {
            int[] clip = clips[i];
            if (!map.containsKey(clip[0]) || clips[map.get(clip[0])][1] < clip[1]) {
                map.put(clip[0], i);
            }
        }

        int res = 0;
        int end = 0;
        int start = 0;
        while (end < T) {
            int max = start;
            int clipIndex = -1;
            for (int i = start; i <= end; i++) {
                if (map.containsKey(i)) {
                    Integer v = map.get(i);
                    if (clips[v][1] > max) {
                        clipIndex = v;
                        max = clips[v][1];
                    }
                }
            }
            if (max == 0 || clipIndex == -1) {
                return -1;
            }
            res++;
            start = clips[clipIndex][0] + 1;
            end = max;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] clips = new int[][]{
                {0, 2},
                {4, 6},
                {8, 10},
                {1, 9},
                {1, 5},
                {5, 9}
        };

        System.out.println(solution.videoStitching(clips, 10));
        System.out.println(solution.videoStitching(new int[][]{{0,1}, {1,2}}, 10));

    }

}
