package com.learn.leetcode._78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/subsets/
 * date: 2020/9/20 21:35
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        dsf(0, new ArrayList<>(), nums, res);
        return res;
    }

    private void dsf(int curr, ArrayList<Integer> item, int[] nums, List<List<Integer>> res) {
        if (curr >= nums.length) {
            return;
        }

        item.add(nums[curr]);
        res.add(new ArrayList<>(item));
        dsf(curr + 1, item, nums, res);
        item.remove(item.size() - 1);

        dsf(curr + 1, item, nums, res);

    }

}
