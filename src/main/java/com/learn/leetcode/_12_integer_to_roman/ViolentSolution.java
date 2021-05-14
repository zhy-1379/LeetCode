package com.learn.leetcode._12_integer_to_roman;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhy
 */
public class ViolentSolution {

    // 1000, 500, 100, 50, 10, 5, 1
    // "M", "D", "C", "L", "X", "V", "I"
    private static final Map<Integer, String> INT_AND_ROMAN_MAP = new HashMap<Integer, String>() { // NOSONAR
        {// NOSONAR
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }
    };

    // 58 -> LVIII
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        char[] chars = String.valueOf(num).toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int positionVal = (int) chars[i] - 48;
            String one = INT_AND_ROMAN_MAP.get((int) (1 * Math.pow(10, len - i - 1)));
            if (positionVal == 9) {
                roman.append(one).append(INT_AND_ROMAN_MAP.get((int) (1 * Math.pow(10, len - i))));
            } else if (positionVal < 9 && positionVal > 5) {
                roman.append(INT_AND_ROMAN_MAP.get((int) (5 * Math.pow(10, len - i - 1))));
                for (int j = 0; j < positionVal - 5; j++) {
                    roman.append(one);
                }
            } else if (positionVal == 4) {
                roman.append(one).append(INT_AND_ROMAN_MAP.get((int) (5 * Math.pow(10, len - i - 1))));
            } else if (positionVal < 4) {
                for (int j = 0; j < positionVal; j++) {
                    roman.append(one);
                }
            } else {
                roman.append(INT_AND_ROMAN_MAP.get((int) (positionVal * Math.pow(10, len - i - 1))));
            }
        }
        return roman.toString();
    }
}
