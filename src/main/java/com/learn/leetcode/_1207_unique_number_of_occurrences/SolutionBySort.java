package com.learn.leetcode._1207_unique_number_of_occurrences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: SolutionBySort
 * Description:
 * date: 2020/10/28 19:01
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionBySort {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int counts = 1;
            while (i < arr.length - 1) {
                if (arr[i + 1] == arr[i]) {
                    counts++;
                    i++;
                } else {
                    break;
                }
            }
            if (set.contains(counts)) {
                return false;
            } else {
                set.add(counts);
            }
        }
        return true;
    }
}
