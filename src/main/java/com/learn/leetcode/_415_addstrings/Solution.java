package com.learn.leetcode._415_addstrings;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/8/3 8:59
 *
 * @author seaxll
 * @since JDK 1.8
 */
class Solution {

    /**
     * 利用字符的 ASCII 码
     *
     * @param num1 参数1
     * @param num2 参数2
     * @return 和
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            sum.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        // 翻转
        sum.reverse();
        return sum.toString();
    }

}
