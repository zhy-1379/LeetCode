package com.learn.leetcode._113_path_sum_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        dsf(res, root, new ArrayList<>(), sum);

        return res;
    }

    private void dsf(List<List<Integer>> res, TreeNode root, ArrayList<Integer> nums, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == sum) {
            ArrayList<Integer> item = new ArrayList<>(nums);
            item.add(root.val);
            res.add(item);
            return;
        }

        // 如果都是正数，才可以这样判断
        // if (sum < root.val) {
        //     return;
        // }

        nums.add(root.val);
        if (root.left != null) {
            dsf(res, root.left, nums, sum - root.val);
        }

        if (root.right != null) {
            dsf(res, root.right, nums, sum - root.val);
        }
        nums.remove(nums.size() - 1);

    }
}
