package com.learn.leetcode._12_integer_to_roman;

/**
 * @author zhy
 */
public class ViolentSolutionV2 {
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(rom[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }
}