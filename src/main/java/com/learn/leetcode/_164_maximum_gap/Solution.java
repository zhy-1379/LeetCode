package com.learn.leetcode._164_maximum_gap;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/11/26 20:57
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(nums[i] - nums[i - 1], maxGap);
        }
        return maxGap;
    }
}
