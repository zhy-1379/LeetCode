package com.learn.leetcode._995_minimum_number_of_k_consecutive_bit_flips;

/**
 * 滑动窗口
 * https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/k-lian-xu-wei-de-zui-xiao-fan-zhuan-ci-s-bikk/
 */
public class SolutionByLeetCodeWithSlidingWindow {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int ans = 0;
        int revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= K && A[i - K] > 1) {
                revCnt ^= 1;
                A[i - K] -= 2; // 复原数组元素，若允许修改数组 A，则可以省略
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}