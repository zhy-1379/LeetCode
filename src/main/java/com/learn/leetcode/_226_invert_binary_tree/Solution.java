package com.learn.leetcode._226_invert_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/16 14:49
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public TreeNode invertTreeByStack(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                //先交换子节点
                TreeNode left = node.left;
                node.left = node.right;
                node.right = left;
                //注意，这里是交换之后的，所以要修改
                node = node.left;
            }
        }
        return root;
    }




}
