package com.learn.leetcode._235_lowest_common_ancestor_of_a_binary_search_tree;

import com.learn.data.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/27 19:44
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {



    // 二叉搜索树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val == q.val) {
            return p;
        }

        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val > q.val ? q : p;

        while (root != null) {
            if (root.val >= min.val && root.val <= max.val) {
                return root;
            }

            if (root.val > max.val) {
                root = root.left;
            }

            if (root.val < min.val) {
                root = root.right;
            }

        }

        return null;
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        findList(pPath, root, p);
        findList(qPath, root, q);

        TreeNode ancestor = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); ++i) {
            if (pPath.get(i) == qPath.get(i)) {
                ancestor = pPath.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    /**
    * 从 root 到 target 的路径
    */
    private boolean findList(List<TreeNode> pList, TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }

        if (root == target) {
            pList.add(root);
            return true;
        }

        if (root.left == null && root.right == null) {
            return false;
        }

        pList.add(root);
        if (findList(pList, root.left, target) || findList(pList, root.right, target)) {
            return true;
        } else {
            pList.remove(root);
            return false;
        }

    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node6.left = node2;
        node6.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;


        Solution solution = new Solution();

        TreeNode treeNode = solution.lowestCommonAncestor2(node6, node2, node8);
        System.out.println(treeNode.val);

    }

}
