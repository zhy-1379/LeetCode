package com.learn.leetcode._19_remove_nth_node_from_end_of_list;

import com.learn.data.bean.ListNode;

/**
 * ClassName: SolutionByDoublePointer
 * Description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * date: 2020/10/18 10:21
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByDoublePointer {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode node = pre;
        ListNode postNNode = pre;
        for (int i = 0; i < n; i++) {
            postNNode = postNNode.next;
        }

        while (postNNode != null) {
            node = node.next;
            postNNode = postNNode.next;
        }
        node.next = node.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = new int[]{1};

        ListNode head = new ListNode(0);
        ListNode node = head;

        for (int value : values) {
            node.next = new ListNode(value);
            node = node.next;
        }

        System.out.println(solution.removeNthFromEnd(head.next, 2));

    }

}
