package com.learn.leetcode._40_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/10 21:37
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int[] candidates;
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(target, 0);
        return ans.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(int target, int index) {
        if (target == 0) {
            ArrayList<Integer> item = new ArrayList<>(temp);
            Collections.sort(item);
            ans.add(item);
            return;
        }

        if (index == candidates.length) {
            return;
        }

        // 不选择当前节点
        dfs(target, index + 1);

        // 选择当前节点
        if (target - candidates[index] >= 0) {
            temp.add(candidates[index]);
            dfs(target - candidates[index], index + 1);
            temp.remove(temp.size() - 1);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).forEach(System.out::println);
    }


}

class Solution2 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}

