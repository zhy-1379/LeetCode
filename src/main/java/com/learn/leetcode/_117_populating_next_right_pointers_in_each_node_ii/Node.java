package com.learn.leetcode._117_populating_next_right_pointers_in_each_node_ii;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public static Node create(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node root = new Node(values[0]);

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 1; i < values.length; i++) {
            if (values[i] != null) {
                Node node = new Node(values[i]);
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

}