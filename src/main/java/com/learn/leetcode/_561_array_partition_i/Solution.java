package com.learn.leetcode._561_array_partition_i;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/2/16 20:47
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
