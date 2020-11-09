package com.learn.leetcode._973_k_closest_points_to_origin;

import java.util.PriorityQueue;

public class SolutionByPriorityQueue {
    public int[][] kClosest(int[][] points, int K) {
        // new int[]{距离，索引};
        PriorityQueue<int[]> pq = new PriorityQueue<>((array1, array2) -> array2[0] - array1[0]);
        // 前 i 个加入队列
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        // 后面的比队首距离更短，移到队首
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        // 返回前 i 个
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }

}
