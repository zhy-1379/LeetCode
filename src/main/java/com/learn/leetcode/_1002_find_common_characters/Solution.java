package com.learn.leetcode._1002_find_common_characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/14 19:25
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public List<String> commonChars(String[] a) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word: a) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        // 26 个字母
        for (int i = 0; i < 26; ++i) {
            // 26 个字母在每个字符串都出现的次数
            for (int j = 0; j < minFreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }


}
