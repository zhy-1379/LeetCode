package com.learn.leetcode._144_binary_tree_preorder_traversal;

import com.learn.data.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: SolutionByIterator
 * Description:
 * date: 2020/10/27 19:41
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByIterator {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                // 和中序遍历的区别，
                // 中序遍历：push 到栈顶前添加到 res 中
                // 先序遍历：pop 后再 添加到 res 中
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


}
