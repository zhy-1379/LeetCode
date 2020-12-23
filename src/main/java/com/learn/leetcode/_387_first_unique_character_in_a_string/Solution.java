package com.learn.leetcode._387_first_unique_character_in_a_string;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int firstUniqChar(String s) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.lastIndexOf(c) == i && !characterList.contains(c)) {
                return i;
            }
            characterList.add(c);
        }
        return -1;
    }
}
