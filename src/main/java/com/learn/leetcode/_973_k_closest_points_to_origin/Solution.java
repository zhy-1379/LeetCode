package com.learn.leetcode._973_k_closest_points_to_origin;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}
