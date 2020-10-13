package com.learn.leetcode._24_swap_nodes_in_pairs;

import com.learn.data.bean.ListNode;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/13 19:09
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionThreePointer {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode preNode = new ListNode(0);
        preNode.next = head;
        ListNode node = head;
        ListNode postNode;

        ListNode resPre = preNode;
        while (node.next != null) {
            // 后置结点
            postNode = node.next;
            // 交换 此结点与 后置结点
            node.next = postNode.next;
            postNode.next = node;
            preNode.next = postNode;

            //
            if (node.next == null) {
                break;
            }
            // 第一个 和 第二个换, 第三个 和 第四个换
            preNode = node;
            node = node.next;
        }

        return resPre.next;
    }

}
