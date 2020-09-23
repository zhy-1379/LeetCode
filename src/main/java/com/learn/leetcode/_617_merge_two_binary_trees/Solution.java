package com.learn.leetcode._617_merge_two_binary_trees;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/merge-two-binary-trees/submissions/
 * date: 2020/9/23 21:49
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }


    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //     if (t1 == null && t2 == null) {
    //         return null;
    //     }
    //
    //     int val1 = t1 == null ? 0 : t1.val;
    //     int val2 = t2 == null ? 0 : t2.val;
    //     TreeNode res = new TreeNode(val1 + val2);
    //
    //     res.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
    //     res.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
    //
    //     return res;
    // }




}
