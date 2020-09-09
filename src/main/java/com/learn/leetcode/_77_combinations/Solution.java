package com.learn.leetcode._77_combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 *  https://leetcode-cn.com/problems/combinations/
 *
 * date: 2020/9/8 21:46
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        if (n > 2 * k) {
            this.n = n;
            this.k = k;
            combine(new ArrayList<>(), 1);
            return res;
        } else {
            this.n = n;
            this.k = n - k;
            combine(new ArrayList<>(), 1);
            List<Integer> all = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                all.add(i);
            }
            List<List<Integer>> temp = new ArrayList<>();
            res.forEach(list -> {
                List<Integer> item = new ArrayList<>(all);
                item.removeAll(list);
                temp.add(item);
            });
            Collections.reverse(temp);
            return temp;
        }

    }

    private void combine(ArrayList<Integer> item, int cur) {
        if (item.size() + (n - cur + 1) < k) {
            return;
        }
        if (item.size() == k) {
            if (res.stream().noneMatch(list -> list.containsAll(item))) {
                res.add(item);
            }
        } else if (item.size() < k){
            for (int j = cur; j <= n; j++) {
                if (!item.contains(j)) {
                    ArrayList<Integer> integers = new ArrayList<>(item);
                    integers.add(j);
                    combine(integers, cur + 1);
                }
            }
        }
    }


    // region 回溯

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine1(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    // endregion


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(13, 10).forEach(System.out::println);
    }

}
