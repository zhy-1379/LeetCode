package com.learn.leetcode._141_linked_list_cycle;

import com.learn.data.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/9 15:38
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode node = head;

        while (node != null) {
            if (!nodes.add(node)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // 双指针，空间复杂度为1
    // public boolean hasCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return false;
    //     }
    //     ListNode slow = head;
    //     ListNode fast = head.next;
    //     while (slow != fast) {
    //         if (fast == null || fast.next == null) {
    //             return false;
    //         }
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return true;
    // }

}