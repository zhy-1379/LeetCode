package com.learn.leetcode._142_linked_list_cycle_ii;

import com.learn.data.bean.ListNode;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/10 20:18
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    // public ListNode detectCycle(ListNode head) {
    //     ListNode node = head;
    //     Set<ListNode> set = new HashSet<>();
    //     while (node != null) {
    //         if (!set.add(node)) {
    //             return node;
    //         }
    //         node = node.next;
    //     }
    //     return null;
    // }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            // 存在环
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }

}
