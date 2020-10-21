package com.learn.leetcode._925_long_pressed_name;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/21 19:21
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;

        char a;
        char b;

        int aNum;
        int bNum;

        while (i < name.length() && j < typed.length()) {
            a = name.charAt(i);
            b = typed.charAt(j);
            if (a != b) {
                return false;
            }

            i++;
            aNum = 1;
            while (i < name.length() && name.charAt(i) == a) {
                aNum++;
                i++;
            }

            j++;
            bNum = 1;
            while (j < typed.length() && typed.charAt(j) == b) {
                bNum++;
                j++;
            }
            if (bNum < aNum) {
                return false;
            }
        }

        return i == name.length() && j == typed.length();
    }

    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

}
