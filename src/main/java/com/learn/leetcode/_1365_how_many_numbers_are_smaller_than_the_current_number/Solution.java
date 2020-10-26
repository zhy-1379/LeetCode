package com.learn.leetcode._1365_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/26 18:42
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int num : nums) {
                if (num < nums[i]) {
                    ++res[i];
                }
            }
        }
        return res;
    }

}
