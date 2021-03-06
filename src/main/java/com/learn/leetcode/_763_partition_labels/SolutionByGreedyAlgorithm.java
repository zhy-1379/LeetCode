package com.learn.leetcode._763_partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SolutionByGreedyAlgorithm
 * Description:
 * date: 2020/10/22 19:49
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByGreedyAlgorithm {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    // public static void main(String[] args) {
    //     SolutionByGreedyAlgorithm solution = new SolutionByGreedyAlgorithm();
    //     solution.partitionLabels("qiejxqfnqceocmy").forEach(System.out::println);
    //
    // }
}
