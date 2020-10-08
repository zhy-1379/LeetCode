package com.learn.leetcode._344_reverse_string;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/8 10:27
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();
    //     char[] s = "abcd".toCharArray();
    //     solution.reverseString(s);
    //     System.out.println(s);
    // }

}
