package com.learn.leetcode._114_binarytreetolist;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/8/2 16:51
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    /**
     * 改变二叉树结构：将所有左子树右旋
     * @param root
     */
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

    public void flatten3(TreeNode root) {
        if(root == null) {
            return;
        }
        // 将左子树展开为单链表
        flatten(root.left);
        // 将右子树展开为单链表
        flatten(root.right);
        // 暂存右子树
        TreeNode temp = root.right;
        // 左子树接到根的右侧
        root.right = root.left;
        // 左子树置空
        root.left = null;
        // 再接上右子树
        while(root.right != null) {
            root = root.right;
        }
        root.right = temp;
    }

}
