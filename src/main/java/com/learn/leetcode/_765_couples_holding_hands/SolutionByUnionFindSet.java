package com.learn.leetcode._765_couples_holding_hands;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: SolutionByUnionFindSet
 * Description:
 * date: 2021/2/14 18:57
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByUnionFindSet {

    public int minSwapsCouples(int[] row) {
        // 人数
        int peopleNum = row.length;
        // 情侣数量
        int loversNum = peopleNum / 2;

        // 并查集
        int[] ufs = new int[loversNum];
        // 初始化并查集
        for (int i = 0; i < loversNum; i++) {
            ufs[i] = i;
        }

        // 遍历相邻的每一对
        for (int i = 0; i < peopleNum; i += 2) {
            int l = row[i] / 2;
            int r = row[i + 1] / 2;
            add(ufs, l, r);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < loversNum; i++) {
            int fx = getUfs(ufs, i);
            map.put(fx, map.getOrDefault(fx, 0) + 1);
        }

        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret += entry.getValue() - 1;
        }
        return ret;
    }

    public int getUfs(int[] ufs, int x) {
        if (ufs[x] == x) {
            return x;
        }
        int newF = getUfs(ufs, ufs[x]);
        ufs[x] = newF;
        return newF;
    }

    public void add(int[] ufs, int x, int y) {
        int fx = getUfs(ufs, x);
        int fy = getUfs(ufs, y);
        ufs[fx] = fy;
    }

    public static void main(String[] args) {
        SolutionByUnionFindSet solution = new SolutionByUnionFindSet();
        int[] row = {0, 2, 4, 6, 7, 1, 3, 5};
        System.out.println(solution.minSwapsCouples(row));
    }

}
