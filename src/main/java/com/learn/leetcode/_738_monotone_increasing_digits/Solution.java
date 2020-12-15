package com.learn.leetcode._738_monotone_increasing_digits;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/12/15 20:56
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        // 前面单调递增的数字不变
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i++;
        }
        if (i < strN.length) {
            // 从递减的那位开始，减一，若减一后，比前一位小，则前一位继续减一
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i--;
            }
            // 后面的全填充 9
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }


}

