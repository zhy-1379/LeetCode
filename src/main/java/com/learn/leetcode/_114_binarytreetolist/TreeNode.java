package com.learn.leetcode._114_binarytreetolist;

/**
 * ClassName: TreeNode
 * Description:
 * date: 2020/8/2 16:48
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
