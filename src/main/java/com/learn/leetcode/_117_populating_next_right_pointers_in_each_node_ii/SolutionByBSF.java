package com.learn.leetcode._117_populating_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description:     https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * date: 2020/9/28 19:49
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByBSF {

    // class Node {
    //     public int val;
    //     public Node left;
    //     public Node right;
    //     public Node next;
    //
    //     public Node() {
    //     }
    //
    //     public Node(int _val) {
    //         val = _val;
    //     }
    //
    //     public Node(int _val, Node _left, Node _right, Node _next) {
    //         val = _val;
    //         left = _left;
    //         right = _right;
    //         next = _next;
    //     }
    // }



    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // while (!queue.isEmpty()) {
        //     LinkedList<Node> layer = new LinkedList<>(queue);
        //     for (int i = 0; i < layer.size() - 1; i++) {
        //         layer.get(i).next = layer.get(i + 1);
        //     }
        //
        //     layer.get(layer.size() - 1).next = null;
        //
        //     queue.clear();
        //     layer.forEach(node -> {
        //         if (node.left != null) {
        //             queue.offer(node.left);
        //         }
        //         if (node.right != null) {
        //             queue.offer(node.right);
        //         }
        //     });
        // }

        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, null, 7};

        Node node = Node.create(values);
        SolutionByBSF solution = new SolutionByBSF();

        solution.connect(node);
    }

}
