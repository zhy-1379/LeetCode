package com.learn.leetcode._283_move_zeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/11/19 20:03
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            while (nums[j] == 0) {
                j++;
                // 后面全是 0 了
                if (j == nums.length) {
                    return;
                }
            }
            int zeroNum = j - i;
            if (zeroNum > 0) {
                System.arraycopy(nums, i + zeroNum, nums, i, len - i - zeroNum);
                for (int k = 1; k <= zeroNum; k++) {
                    nums[len - k] = 0;
                }
                len--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
