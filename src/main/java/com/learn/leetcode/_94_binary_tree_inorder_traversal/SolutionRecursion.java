package com.learn.leetcode._94_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * date: 2020/9/14 21:11
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionRecursion {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
         middlePreface(list, root);
         return list;
    }

    private void middlePreface(List<Integer> list, TreeNode root) {
        if (root == null) return;
        middlePreface(list, root.left);
        list.add(root.val);
        middlePreface(list, root.right);
    }


}
