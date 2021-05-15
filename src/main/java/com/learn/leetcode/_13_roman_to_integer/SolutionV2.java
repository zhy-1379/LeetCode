package com.learn.leetcode._13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 */
public class SolutionV2 {

    // 1000, 500, 100, 50, 10, 5, 1
    // "M", "D", "C", "L", "X", "V", "I"
    private static final Map<Character, Integer> ROMAN_AND_INT_MAP = new HashMap<Character, Integer>() { // NOSONAR
        {// NOSONAR
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }
    };


    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = ROMAN_AND_INT_MAP.get(s.charAt(i));
            if (i < n - 1 && value < ROMAN_AND_INT_MAP.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

}
