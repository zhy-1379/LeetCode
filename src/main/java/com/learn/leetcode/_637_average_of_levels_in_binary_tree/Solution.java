package com.learn.leetcode._637_average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * date: 2020/9/12 20:46
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            // ans.add(queue.stream().map(node -> node.val).mapToDouble(s -> s).summaryStatistics().getAverage());
            double all = 0;
            for (TreeNode node : queue) {
                all += node.val;
            }
            ans.add(all / size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode node_3 = new TreeNode(3);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_20 = new TreeNode(20);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_7 = new TreeNode(7);

        node_3.left = node_9;
        node_3.right = node_20;
        node_20.left = node_15;
        node_20.right = node_7;

        System.out.println(solution.averageOfLevels(node_3));


    }


}



