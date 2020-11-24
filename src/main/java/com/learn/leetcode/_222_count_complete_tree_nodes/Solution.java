package com.learn.leetcode._222_count_complete_tree_nodes;

import com.learn.data.bean.TreeNode;

/**
 * ClassName: Solution
 * Description:https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * data: 2020/11/24 20:42
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
