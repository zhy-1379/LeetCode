package com.learn.leetcode._228_summary_ranges;

import com.learn.utils.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/1/10 15:55
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == nums[i]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i]);
                }
                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        LoggerUtils.info(Solution.class, new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
