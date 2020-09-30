package com.learn.leetcode._701_insert_into_a_binary_search_tree;

import com.learn.data.bean.TreeNode;

/**
 * ClassName: SolutionIterator
 * Description:
 * date: 2020/9/30 21:59
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionIterator {

    // todo: 保证二叉树的平衡
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = root;
        TreeNode prev = root;

        while (true) {
            if (node == null) {
                node = new TreeNode(val);
                if (prev == null) {
                    return node;
                }
                if (prev.val > val) {
                    prev.left = node;
                } else {
                    prev.right = node;
                }
                break;
            }

            prev = node;
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return root;
    }
}
