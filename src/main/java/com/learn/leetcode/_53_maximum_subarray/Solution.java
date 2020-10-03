package com.learn.leetcode._53_maximum_subarray;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/3 20:53
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxSubArray(new int[]{0}));
    }


}
