package com.learn.leetcode._973_k_closest_points_to_origin;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        int[] ds = new int[points.length];
        Arrays.fill(ds, 0);
        for (int i = 0; i < K; i++) {
            int minIdx = i;
            if (ds[i] == 0) {
                ds[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            }
            for (int j = i; j < points.length; j++) {
                if (ds[j] == 0) {
                    ds[j] = points[j][0] * points[j][0] + points[j][1] * points[j][1];
                }
                if (ds[j] < ds[minIdx]) {
                    minIdx = j;
                }
            }
            res[i] = points[minIdx];
            ds[minIdx] = Integer.MAX_VALUE;
        }
        return res;
    }


    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}
