package com.learn.leetcode._995_minimum_number_of_k_consecutive_bit_flips;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Solution
 * Description:
 * date: 2021/2/18 11:12
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution01 {

    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (!que.isEmpty() && i > que.peek() + K - 1) {
                que.removeFirst();
            }
            // 1.本来是1，翻转奇数次变为0，所以需要再次翻转，放入队列
            // 2.本来是0，翻转偶数次还是0，所以需要再次翻转，放入队列
            if (que.size() % 2 == A[i]) {
                if (i + K > A.length) return -1;
                que.add(i);
                res += 1;
            }
        }
        return res;
    }

}
