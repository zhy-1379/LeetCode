package com.learn.leetcode._94_binary_tree_inorder_traversal;

import java.util.*;

/**
 * ClassName: SolutionIterator
 * Description:
 * date: 2020/9/14 21:19
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionIterator {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        // List<TreeNode> hasIterator = new ArrayList<>();
        // stack.push(root);
        // while (!stack.isEmpty()) {
        //     TreeNode node = stack.peek();
        //     if (hasIterator.contains(node)) {
        //         continue;
        //     }
        //     if (node.left != null && !hasIterator.contains(node.left)) {
        //         stack.push(node.left);
        //     } else {
        //         node = stack.pop();
        //         list.add(node.val);
        //         hasIterator.add(node);
        //         if (node.right != null) {
        //             stack.push(node.right);
        //         }
        //     }
        // }

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


}
