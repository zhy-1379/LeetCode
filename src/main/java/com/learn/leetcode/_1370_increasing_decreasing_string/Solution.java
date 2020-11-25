package com.learn.leetcode._1370_increasing_decreasing_string;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/11/25 20:26
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public String sortString(String s) {
        // 直接创建一个大小为 26 的桶，记录每种字符的数量
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder ret = new StringBuilder();
        // 每次提取最长的上升或下降字符串时，我们直接顺序或逆序遍历这个桶
        while (ret.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (num[i] > 0) {
                    ret.append((char) (i + 'a'));
                    num[i]--;
                }
            }
        }
        return ret.toString();
    }
}

