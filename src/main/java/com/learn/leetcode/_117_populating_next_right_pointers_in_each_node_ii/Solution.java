package com.learn.leetcode._117_populating_next_right_pointers_in_each_node_ii;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/9/28 20:29
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    Node last = null;
    Node nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}