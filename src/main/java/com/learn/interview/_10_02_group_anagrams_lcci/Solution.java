package com.learn.interview._10_02_group_anagrams_lcci;

import java.util.*;

/**
 * @author zhy
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(new String(chars), e -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
