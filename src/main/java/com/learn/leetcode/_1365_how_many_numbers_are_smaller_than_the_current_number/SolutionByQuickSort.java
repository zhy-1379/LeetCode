package com.learn.leetcode._1365_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: SolutionByQuickSort
 * Description:
 * date: 2020/10/26 20:00
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByQuickSort {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[][] data = new int[len][2];
        for (int i = 0; i < len; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, Comparator.comparingInt(data2 -> data2[0]));

        int[] ret = new int[len];
        int prev = -1;
        for (int i = 0; i < len; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }

}
