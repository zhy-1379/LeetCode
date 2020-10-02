package com.learn.leetcode._771_jewels_and_stones;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/2 8:36
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int numJewelsInStones(String j, String s) {
        int num = 0;

        if (j == null || j.isEmpty() || s == null || s.isEmpty()) {
            return num;
        }

        List<String> jewelsList = Arrays.asList(j.split(""));

        for (int i = 0; i < s.length(); i++) {
            if (jewelsList.contains(String.valueOf(s.charAt(i)))) {
                num ++;
            }
        }

        return num;
    }

}
