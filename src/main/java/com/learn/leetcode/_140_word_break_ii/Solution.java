package com.learn.leetcode._140_word_break_ii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/11/1 9:54
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private static Logger log = LoggerFactory.getLogger(Solution.class);

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        dsf(s, wordDict, res, new ArrayList<>(), 0);

        return res;
    }

    private void dsf(String s, List<String> wordDict, List<String> res, List<String> item, int index) {
        log.info("dsf with index is {}", index);
        log.info("\t--res.length is {}", res.size());
        log.info("\t--item is {}", Arrays.toString(item.toArray(new String[0])));

        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < item.size(); i++) {
                sb.append(item.get(i));
                if (i != item.size() - 1) {
                    sb.append(" ");
                }
            }
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
        }


        for (int i = index + 1; i < s.length() + 1; i++) {
            String sub = s.substring(index, i);
            if (wordDict.stream().anyMatch(sub::equals)) {
                item.add(sub);
                log.info("\t\t--match {} success and add to item", sub);
                dsf(s, wordDict, res, item, i);
                log.info("\t\t--remove {}", item.get(item.size() - 1));
                item.remove(sub);
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        String[] wordDict = new String[]{"cat", "cats", "and", "sand", "dog"};

        solution.wordBreak(s, new ArrayList<>(Arrays.asList(wordDict))).forEach(System.out::println);
    }

}
