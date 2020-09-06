package com.learn.leetcode._107_binary_tree_level_order_traversal_ii;

import java.util.*;

/**
 * ClassName: Solution
 * Description:
 *  https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * date: 2020/9/6 20:31
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    // region 遍历每一层
    private List<List<Integer>> order = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return order;
        }

        List<TreeNode> layer = new ArrayList<>();
        layer.add(root);
        loadLayer(layer);
        Collections.reverse(order);
        return order;
    }

    private void loadLayer(List<TreeNode> layer) {
        List<Integer> values = new ArrayList<>();
        layer.forEach(node -> values.add(node.val));
        order.add(values);
        List<TreeNode> nextLayer = new ArrayList<>();
        layer.forEach(node -> {
            if (node.left != null) {
                nextLayer.add(node.left);
            }

            if (node.right != null) {
                nextLayer.add(node.right);
            }
        });
        if (!nextLayer.isEmpty()) {
            loadLayer(nextLayer);
        }
    }

    // endregion

    // region 队列实现
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }

    // endregion


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

