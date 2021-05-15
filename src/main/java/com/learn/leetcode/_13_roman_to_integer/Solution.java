package com.learn.leetcode._13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 */
public class Solution {

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
        char[] chars = s.toCharArray();
        int resIntNum = 0;
        int preNum = 0;
        for (char aChar : chars) {
            int num = ROMAN_AND_INT_MAP.get(aChar);
            if (preNum < num) {
                resIntNum -= preNum * 2;
            }
            resIntNum += (preNum = num);
        }
        return resIntNum;
    }

}
