package com.learn.leetcode._78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution2
 * Description:
 * date: 2020/9/20 22:40
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> item = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        for (int mask = 0; mask < (1 << len); ++mask) {
            item.clear();
            for (int i = 0; i < len; ++i) {
                if ((mask & (1 << i)) != 0) {
                    item.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(item));
        }
        return res;
    }


}
