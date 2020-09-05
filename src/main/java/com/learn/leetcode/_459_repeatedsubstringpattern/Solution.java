package com.learn.leetcode._459_repeatedsubstringpattern;

/**
 * ClassName: Solution
 * Description:
 *  https://leetcode-cn.com/problems/repeated-substring-pattern/
 * date: 2020/8/24 20:28
 *
 * @author seaxll
 * @since JDK 1.8
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            String n = s.substring(0, i);
            int nLen = n.length();
            int count = len / nLen;
            StringBuilder s1 = new StringBuilder();
            for (int j = 0; j < count; j++) {
                s1.append(n);
            }

            if (s1.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abcabc"));
        System.out.println(solution.repeatedSubstringPattern("abcabcf"));
    }


}
