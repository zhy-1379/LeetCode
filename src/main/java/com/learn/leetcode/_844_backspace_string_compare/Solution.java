package com.learn.leetcode._844_backspace_string_compare;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/19 19:30
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        }

        if (S == null || T == null) {
            return false;
        }

        return process(S).equals(process(T));
    }

    private String process(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char aChar : chars) {
            if (aChar == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(aChar);
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

}
