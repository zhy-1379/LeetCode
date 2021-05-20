package com.learn.leetcode._692_top_k_frequent_words;

import java.util.*;

/**
 * 返回 words 中出现次数最高的 k 个单词
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决
 *
 * @author zhy
 */
public class SolutionWithPriorityQueue {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((b, a) -> {
            int compare = Integer.compare(b.getValue(), a.getValue());
            if (compare != 0) {
                return compare;
            }
            return a.getKey().compareTo(b.getKey());
        });
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }
}
