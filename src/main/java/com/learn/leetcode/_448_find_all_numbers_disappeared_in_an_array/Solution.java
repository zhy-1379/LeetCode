package com.learn.leetcode._448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/2/13 10:37
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        // 遍历 nums，将 nums[nums[i]] 的大小加 len
        for (int num : nums) {
            nums[(num - 1) % len] += len;
        }

        // 如果 nums[i] <= len, 则 i 是 nums 中未出现过的数字
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(solution.findDisappearedNumbers(nums));
    }
}
