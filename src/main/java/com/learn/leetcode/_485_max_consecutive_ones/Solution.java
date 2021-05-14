package com.learn.leetcode._485_max_consecutive_ones;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/2/15 14:04
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 0) {
                maxCount = Math.max(count, maxCount);
                count = 0;
            } else {
                count++;
            }
        }
        maxCount = Math.max(count, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};

        System.out.println(solution.findMaxConsecutiveOnes(nums));
    }

}
