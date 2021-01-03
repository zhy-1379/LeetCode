package com.learn.leetcode._86_partition_list;

import com.learn.data.bean.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        // greater than
        ListNode preGt = new ListNode();
        ListNode gt = preGt;
        // less than
        ListNode preLt = new ListNode();
        ListNode lt = preLt;

        while (head != null) {
            if (head.val >= x) {
                gt.next = head;
                gt = gt.next;
            } else {
                lt.next = head;
                lt = lt.next;
            }
            head = head.next;
        }

        lt.next = preGt.next;
        // 最后一个节点的尾节点置空，避免循环
        gt.next = null;

        return preLt.next;
    }

}
