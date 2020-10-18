package com.learn.leetcode._19_remove_nth_node_from_end_of_list;

import com.learn.data.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * date: 2020/10/18 9:59
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }

        int nodeIndex = listNodes.size() - n;
        int preIndex = nodeIndex - 1;
        if (preIndex < 0) {
            return listNodes.get(0).next;
        }

        node = listNodes.get(nodeIndex);
        ListNode pre = listNodes.get(preIndex);

        pre.next = node.next;

        return head;
    }



}
