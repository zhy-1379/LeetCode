package com.learn.leetcode._454_4sum_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SolutionByGropuAndHash
 * Description:
 * data: 2020/11/27 22:03
 *
 * @author zhy
 * @version 1.0
 */
public class SolutionByGroupAndHash {

    /**
     * A B C D 各选一个元素组成四元组，和为0的个数。
     * solution：
     * 将 A B C D 各选一个组成四元组，看作是选两个二元组出来，转换成求 AB CD 两个数组中各选一个，其和为0的个数。
     * 若对于 AB 中的 v，CD 存在 n 个 -v，则结果加 n。
     * 使用 HashMap 实现。
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                countAB.put(a + b, countAB.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                if (countAB.containsKey(-c - d)) {
                    ans += countAB.get(-c - d);
                }
            }
        }
        return ans;
    }
}
