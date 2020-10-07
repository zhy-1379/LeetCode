package com.learn.leetcode._75_sort_colors;

import java.util.Random;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/7 9:28
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    // public void sortColors(int[] nums) {
    //     int boundary = 0;
    //     for (int i = 0; i < nums.length; ++i) {
    //         if (nums[i] == 0) {
    //             int temp = nums[i];
    //             nums[i] = nums[boundary];
    //             nums[boundary] = temp;
    //             ++boundary;
    //         }
    //     }
    //     for (int i = boundary; i < nums.length; ++i) {
    //         if (nums[i] == 1) {
    //             int temp = nums[i];
    //             nums[i] = nums[boundary];
    //             nums[boundary] = temp;
    //             ++boundary;
    //         }
    //     }
    // }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }



    
}
