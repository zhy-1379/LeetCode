package com.learn.leetcode._127_word_ladder;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/11/5 19:41
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    // 超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int dsf = dsf(beginWord, endWord, wordList);
        if (dsf > 0 && dsf <= wordList.size()) {
            return dsf;
        }
        return 0;
    }


    private int dsf(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        int minDist = Integer.MAX_VALUE;
        for (String s : wordList) {
            if (isMatch(beginWord, s)) {
                ArrayList<String> list = new ArrayList<>(wordList);
                list.remove(s);
                int dsf = dsf(s, endWord, list);
                if (dsf <= wordList.size() && dsf > 0) {
                    minDist = Math.min(dsf + 1, minDist);
                }
            }
        }
        return minDist;
    }

    private boolean isMatch(String a, String b) {
        int num = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                num--;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("hot");
        list.add("dot");

        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hot", "dog", list));
    }


}
