package com.learn.leetcode._701_insert_into_a_binary_search_tree;

import com.learn.data.bean.TreeNode;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/30 21:44
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionRecursion {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }





}
