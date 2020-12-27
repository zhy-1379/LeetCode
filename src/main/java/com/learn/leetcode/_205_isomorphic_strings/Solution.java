package com.learn.leetcode._205_isomorphic_strings;

import com.learn.utils.LoggerUtils;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char currentS = s.charAt(i);
            char currentT = t.charAt(i);
            if ((s2t.containsKey(currentS)
                    && s2t.get(currentS) != currentT)
                    || (t2s.containsKey(currentT)
                    && t2s.get(currentT) != currentS)) {
                return false;
            }
            s2t.put(currentS, currentT);
            t2s.put(currentT, currentS);
        }
        return true;
    }


    public static void main(String[] args) {
        LoggerUtils.info(Solution.class, String.valueOf(new Solution().isIsomorphic("adg", "egg")));
    }


}
