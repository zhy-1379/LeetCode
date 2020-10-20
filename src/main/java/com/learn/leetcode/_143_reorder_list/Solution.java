package com.learn.leetcode._143_reorder_list;

import com.learn.data.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/20 18:53
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        List<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }

        node = head;
        for (int i = 0; i <= listNodes.size() / 2; i++) {
            ListNode node1 = listNodes.get(i);
            ListNode node2 = listNodes.get(listNodes.size() - i - 1);

            if (node != head) {
                node.next = node1;
            }

            if (node1.next == node2 || node1 == node2) {
                node = node2;
                break;
            }
            node1.next = node2;
            node = node2;
        }

        node.next = null;
    }

}
