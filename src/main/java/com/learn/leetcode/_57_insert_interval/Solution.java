package com.learn.leetcode._57_insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/11/4 20:37
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();

        int left = newInterval[0];
        int right = newInterval[1];
        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1] || interval[1] < newInterval[0]) {
                list.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        int[][] res = new int[list.size() + 1][2];

        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] >= left && !flag) {
                flag = true;
                res[i] = new int[]{left, right};
            }
            if (flag) {
                res[i + 1] = list.get(i);
            } else {
                res[i] = list.get(i);
            }
        }
        if (!flag) {
            res[res.length - 1] = new int[]{left, right};
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.insert(
                new int[][]{{2, 5}, {6, 7}, {8, 9}}, new int[]{0, 1})));
    }

}
