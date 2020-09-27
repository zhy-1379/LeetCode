package com.learn.data.bean;

import java.util.*;

/**
 * ClassName: TreeNode
 * Description:
 * date: 2020/9/27 20:48
 *
 * @author zhy
 * @since JDK 1.8
 */
public class TreeNode {
    // leetCode 使用的二叉树，访问权限写成 public 以便 和 LeetCode 调用一致
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    /**
     *                 0
     *      1=0*2+1         2=0*2+2
     *  3=1*2+1  4=1*2+2  5=2*2+1 6=2*2+2
     *
     */
    public static TreeNode create(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null) {
                TreeNode node = new TreeNode(values[i]);
                if (i % 2 != 0) {
                    nodes.get((i - 1) / 2).left = node;
                } else {
                    nodes.get((i - 2) / 2).right = node;
                }
                nodes.add(node);
            }

        }

        return root;
    }



    public Integer[] valuesArray() {
        return valuesList().toArray(new Integer[0]);
    }

    public List<Integer> valuesList() {
        ArrayList<Integer> values = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            if (queue.stream().noneMatch(Objects::nonNull)) {
                break;
            }

            TreeNode node = queue.poll();
            if (node == null) {
                values.add(null);
                queue.offer(null);
                queue.offer(null);
            } else {
                values.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return values;
    }

    private boolean hasChild() {
        return this.left != null || this.right != null;
    }

}