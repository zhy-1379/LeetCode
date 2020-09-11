package com.learn.leetcode._216_combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:https://leetcode-cn.com/problems/combination-sum-iii/
 * <p>
 * date: 2020/9/11 20:59
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dsf(n, 1);

        return ans;
    }

    /**
     * 相加之和为 n 的 k 个数的组合
     */
    private void dsf(int n, int cuur) {
        if (n == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        }

        if (temp.size() == k) {
            return;
        }

        if (n < cuur) {
            return;
        }

        if (cuur > 9) {
            return;
        }

        // 选择当前数字
        temp.add(cuur);
        dsf(n - cuur, cuur + 1);
        temp.remove(temp.size() - 1);
        // 不选择当前数
        dsf(n, cuur + 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum3(3, 7).forEach(System.out::println);
    }

}
