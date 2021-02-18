package com.learn.leetcode._995_minimum_number_of_k_consecutive_bit_flips;

/**
 * ClassName: SolutionSimple
 * Description:
 * 以下情况可以通过两次 N 位反转消除所有的 0
 * 1. 0[(N-1) 个 1]0
 * 2. 00[(N-2) 个 1]00
 * 3. 000[(N-3) 个 1]000
 * ...
 * N - 1. [(N - 1) 个 0]1[(N - 1) 个 0]
 * <p>
 * 如 k = 3 时：
 * 0110 -> 1000 -> 1111
 * 00100 -> 11000 -> 11111
 * <p>
 * 传递：
 * 0010100 -> 1100100 -> 1111000 -> 1111111
 * <p>
 * 如 K = 4：
 * 01110 -> 10000 -> 11111
 * 001100 -> 110000 -> 111111
 * 0001000 -> 1110000 -> 1111111
 * <p>
 * 传递：
 * 0001001000 -> 1110001000 -> 1111110000 -> 1111111111
 * 0001 01101000 -> 111 0011 01000 -> 11111 0001 000-> 11111111 0000 -> 111111111111
 * <p>
 * date: 2021/2/18 16:12
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionSimple {

    public int minKBitFlips(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                // 若遍历翻转后, 数组无法以 K 个 0 结尾, 则无法将其全部翻转成 1
                if (i + K > A.length) {
                    return -1;
                }
                // 直接将 0 开始的 K 个数字 翻转
                for (int j = i; j < i + K; j++) {
                    A[j] ^= 1;
                }
                count++;
            }
        }
        return count;
    }

}
