package com.learn.leetcode._145_binary_tree_postorder_traversal;

import com.learn.data.bean.TreeNode;

import java.util.*;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/29 21:41
 *
 * @author zhy
 * @since JDK 1.8
 */
@SuppressWarnings("java:S1121")
public class SolutionIterator {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> poster = new ArrayList<>();
        if (root == null) {
            return poster;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        // 遍历到某个结点是，需要判断其右子树是否遍历过，
        // 使用一个 prev 记录上次遍历的可能是右子树的结点
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 左子树入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 如果取出结点的右子树为 null 或者 右子树是上次遍历成功的结点
            if ((root = stack.pop()).right == null || root.right == prev) {
                poster.add(root.val);
                prev = root;
                root = null;
            } else {
                // 左子树遍历后是右子树，将右子树入栈
                stack.push(root);
                root = root.right;
            }
        }
        return poster;
    }

}
