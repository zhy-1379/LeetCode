package com.learn.leetcode._2_add_two_numbers;

import com.learn.data.bean.ListNode;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/4 9:36
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(-1);
        ListNode node = preNode;
        int value = 0;
        while(l1 != null || l2 != null || value != 0) {
            if(l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(value % 10);
            node = node.next;
            value /= 10;
        }
        return preNode.next;
    }
}
