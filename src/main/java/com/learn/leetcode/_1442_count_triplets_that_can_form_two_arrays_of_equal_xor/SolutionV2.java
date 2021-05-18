package com.learn.leetcode._1442_count_triplets_that_can_form_two_arrays_of_equal_xor;

/**
 * @author zhy
 */
public class SolutionV2 {

    /**
     * 根据 {@link Solution} 可知，需要找到：prefix[i] = prefix[k + 1]
     * 则 结果与 j 无关，当 prefix[i] = prefix[k + 1] 成立时，任意 i < j <= k 都满足。
     */
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < len; ++i) {
            for (int k = i + 1; k < len; ++k) {
                if (prefix[i] == prefix[k + 1]) {
                    count += (k - i);
                }
            }
        }
        return count;
    }
}