package com.learn.leetcode._145_binary_tree_postorder_traversal;

import com.learn.data.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/29 21:33
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionRecursion {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> poster = new ArrayList<>();
        recursionPost(poster, root);
        return poster;
    }

    private void recursionPost(List<Integer> poster, TreeNode root) {
        if (root == null) {
            return;
        }
        recursionPost(poster, root.left);
        recursionPost(poster, root.right);
        poster.add(root.val);
    }
}
