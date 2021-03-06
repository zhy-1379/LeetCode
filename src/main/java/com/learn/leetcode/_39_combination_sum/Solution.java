package com.learn.leetcode._39_combination_sum;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/combination-sum/
 *
 * date: 2020/9/9 19:48
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> combine = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        nums = candidates;
        dfs(target, 0);
        return ans;
    }

    /**
     * @param target 剩余需要组合的值
     * @param idx   组合 num 的索引
     */
    public void dfs(int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        if (idx == nums.length) {
            return;
        }


        // 不选择当前数
        dfs(target, idx + 1);
        // 选择当前数
        if (target - nums[idx] >= 0) {
            // 使用原引用，提高效率，递归调用前 加入列表，递归调用后，移除加入的一项，避免创建新的 List 浪费空间
            combine.add(nums[idx]);
            // 如果可以选择重复的数，idx 不变
            // dfs(target - nums[idx], idx);
            // 如果不选择重复的数，idx 在此 +1
            dfs(target - nums[idx], idx + 1);
            combine.remove(combine.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{3, 2, 7, 4,5}, 9).forEach(System.out::println);
    }

}
