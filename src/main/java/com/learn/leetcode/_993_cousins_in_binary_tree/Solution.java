package com.learn.leetcode._993_cousins_in_binary_tree;

import com.learn.data.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhy
 */
public class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        int layerX = 0;
        int layerY = 0;
        TreeNode preX = null;
        TreeNode preY = null;
        int layer = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 广度遍历
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    int val = node.left.val;
                    if (val == x) {
                        layerX = layer + 1;
                        preX = node;
                    } else if (val == y) {
                        layerY = layer + 1;
                        preY = node;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    int val = node.right.val;
                    if (val == x) {
                        layerX = layer + 1;
                        preX = node;
                    } else if (val == y) {
                        layerY = layer + 1;
                        preY = node;
                    }
                    queue.offer(node.right);
                }
            }
            layer++;
        }

        return layerX == layerY && preX != preY;
    }


}
