package com.learn.leetcode._316_remove_duplicate_letters;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/12/20 17:18
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int length = s.length();
        // 用长度为 26 的 boolean 型数组记录 a-z 26 个字母是否在 s 中出现
        boolean[] isContains = new boolean[26];
        // 记录 26 个字母在 s 中最后出现的索引
        int[] lastIndex = new int[26];
        // 遍历 s
        for (int i = 0; i < length; i++) {
            lastIndex[s.charAt(i) - 'a']++;
        }

        // sb 看作是一个栈
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (!isContains[ch - 'a']) {
                // 如果栈非空，并且栈顶的值大于当前字符
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    // 当前字符在 s 中还会出现
                    if (lastIndex[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        isContains[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                isContains[ch - 'a'] = true;
                sb.append(ch);
            }
            lastIndex[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
