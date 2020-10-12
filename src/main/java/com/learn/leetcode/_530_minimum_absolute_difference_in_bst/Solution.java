package com.learn.leetcode._530_minimum_absolute_difference_in_bst;

import com.learn.data.bean.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/12 19:16
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    // 普通 二叉树
    // public int getMinimumDifference(TreeNode root) {
    //     int res = Integer.MAX_VALUE;
    //     List<Integer> nums = new ArrayList<>();
    //
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //
    //     while (!queue.isEmpty()) {
    //         TreeNode node = queue.poll();
    //         Integer val = node.val;
    //         if (nums.contains(val)) {
    //             return 0;
    //         }
    //         nums.add(val);
    //
    //         if (node.left != null) {
    //             queue.offer(node.left);
    //         }
    //         if (node.right != null) {
    //             queue.offer(node.right);
    //         }
    //     }
    //
    //     Collections.sort(nums);
    //
    //     for (int i = 0; i < nums.size() - 1; i++) {
    //         res = Math.min(res, nums.get(i + 1) - nums.get(i));
    //     }
    //
    //     return res;
    // }

    // 二叉搜索树 递归
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        def(root);
        return res;
    }

    private void def(TreeNode node) {
        if (node == null) {
            return;
        }
        def(node.left);

        if (pre != null) {
            res = Math.min(node.val - pre.val, res);
        }
        pre = node;
        def(node.right);
    }

    // 二叉搜索树 迭代
    public int getMinimumDifference2(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int preVal = -1;
        TreeNode temp = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode node = stack.pop();
            temp = node.right;
            if (preVal != -1) {
                ans = Math.min(node.val - preVal, ans);
            }
            preVal = node.val;
        }
        return ans;
    }


}
