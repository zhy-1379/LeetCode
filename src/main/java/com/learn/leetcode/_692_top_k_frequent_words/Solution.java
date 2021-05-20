package com.learn.leetcode._692_top_k_frequent_words;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 返回 words 中出现次数最高的 k 个单词
 *
 * @author zhy
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            int compare = Integer.compare(b.getValue(), a.getValue());
            if (compare != 0) {
                return compare;
            }
            return a.getKey().compareTo(b.getKey());
        };
        return countMap.entrySet().stream().sorted(comparator).map(Map.Entry::getKey).collect(Collectors.toList()).subList(0, k);
    }


}
