package com.learn.leetcode._24_swap_nodes_in_pairs;

import com.learn.data.bean.ListNode;

/**
 * ClassName: SolutionIRecursion
 * Description:
 * date: 2020/10/13 19:41
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionIRecursion {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode postNode = head.next;
        head.next = swapPairs(postNode.next);
        postNode.next = head;
        return postNode;
    }

}
