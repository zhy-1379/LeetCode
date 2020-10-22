package com.learn.leetcode._763_partition_labels;

import java.util.*;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/22 19:18
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Set<Character> hasIterator = new HashSet<>();

        int start = 0;
        int i;
        int end;
        while (start < S.length()) {
            end = S.lastIndexOf(S.charAt(start));
            i = start;
            while (++i < end) {
                char aChar = S.charAt(i);
                if (hasIterator.add(aChar)) {
                    int lastIndexOfAChar = S.lastIndexOf(aChar);
                    if (lastIndexOfAChar > end) {
                        end = lastIndexOfAChar;
                    }
                }
            }
            res.add(end + 1 - start);
            start = end + 1;
        }
        return res;
    }

    //
    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     solution.partitionLabels("qiejxqfnqceocmy").forEach(System.out::println);
    // }

}
