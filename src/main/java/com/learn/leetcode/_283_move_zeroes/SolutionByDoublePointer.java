package com.learn.leetcode._283_move_zeroes;

/**
 * ClassName: SolutionByDoublePointer
 * Description:
 * data: 2020/11/19 20:35
 *
 * @author zhy
 * @version 1.0
 */
public class SolutionByDoublePointer {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
