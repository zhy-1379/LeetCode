package com.learn.leetcode._485_max_consecutive_ones;

/**
 * ClassName: SolutionByDoublePoint
 * Description:
 * date: 2021/2/15 14:10
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByDoublePoint {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && nums[j] == 1) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j + 1;
        }
        return res;
    }

}
