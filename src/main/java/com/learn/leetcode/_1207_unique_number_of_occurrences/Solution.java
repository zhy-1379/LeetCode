package com.learn.leetcode._1207_unique_number_of_occurrences;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/28 18:47
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        return map.values().size() == new HashSet<>(map.values()).size();
    }

}
