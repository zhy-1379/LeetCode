package com.learn.leetcode._144_binary_tree_preorder_traversal;

import com.learn.data.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/27 19:30
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(res, root);
        return res;
    }

    private void preOrder(List<Integer> res, TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preOrder(res, root.left);
            preOrder(res, root.right);
        }
    }

}
