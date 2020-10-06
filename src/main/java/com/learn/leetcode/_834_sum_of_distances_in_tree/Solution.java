package com.learn.leetcode._834_sum_of_distances_in_tree;

import java.util.*;

/**
 * ClassName: Solution
 * Description: 官方题解
 * date: 2020/10/6 9:38
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private int[] ans;
    // sz[u]: 以 u 为根的子树的结点数量
    private int[] sz;
    // dp[u]: 以 u 为根的子树的所有子节点到它的距离之和
    // 可知：若 b 是 a 的儿子树，b 所有子节点到他的距离之和已知，
    // 则: b 的子节点到 a 的距离是 b 的子节点到 b 的距离 加一
    // 则: b 的子节点到 a 的距离之和 b 的子节点数到 b 的距离之和 加上 b 的子节点数
    // 即：b 的所有结点（包括b）到 a 的距离之和 = b 的子节点数到 b 的距离之和 + b 的节点数（b 中的子节点数 + 1）
    // 而：a 的所有结点到 a 的距离 之和 = (a 的所有一代子节点的子节点到它的距离之和加上它的节点数之和)之和
    // 即：dp[u] = sum(dp[v] + sz[v]) 其中，v 是 u 的儿子树  ———— ①
    // 计算 其他节点时，将这些结点边做根节点即可（使用dsf，每颗子树在其父树的基础上变换）
    private int[] dp;
    // 记录树的结点信息
    private List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f) {
        ans[u] = dp[u];
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            int pu = dp[u];
            int pv = dp[v];
            int su = sz[u];
            int sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(6, edges)));
    }

}
