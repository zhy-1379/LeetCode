package com.learn.leetcode._116_populating_next_right_pointers_in_each_node;

import com.learn.leetcode._117_populating_next_right_pointers_in_each_node_ii.Node;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/15 19:27
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 从根节点开始
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
