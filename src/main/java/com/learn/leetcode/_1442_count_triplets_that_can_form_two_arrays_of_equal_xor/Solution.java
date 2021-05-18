package com.learn.leetcode._1442_count_triplets_that_can_form_two_arrays_of_equal_xor;

/**
 * @author zhy
 */
public class Solution {

    /**
     * 根据题意，要找到 i j k (0 <= i < j <= k < arr.length) 使得：
     * - arr[i] ⊕ ... ⊕ arr[j-1] = arr[j] ⊕...⊕ arr[k]  ———— ①
     * 由于：x ⊕ x = 0，0 ⊕ x = x
     * 可得出等式 ②：(arr[0] ⊕ ... ⊕ arr[i-1]) ⊕ (arr[0] ⊕ ... ⊕ arr[i-1]) ⊕ (arr[i] ⊕ ... ⊕ arr[j-1]) = (arr[0] ⊕ ... ⊕ arr[j-1]) ⊕ (arr[0] ⊕ ... ⊕ arr[j-1]) ⊕ (arr[j] ⊕ ... ⊕ arr[k])  —— ②
     * 可得出等式 ③：(arr[0] ⊕ ... ⊕ arr[i-1]) ⊕ (arr[0] ⊕ ... ⊕ arr[j-1]) = (arr[0] ⊕ ... ⊕ arr[j-1]) ⊕ (arr[0] ⊕ ... ⊕ arr[k])    ———— ③
     * 可得出等式 ④：(arr[0] ⊕ ... ⊕ arr[i-1]) = (arr[0] ⊕ ... ⊕ arr[k])    ———— ④
     * 令：prefix[i] = arr[0] ⊕...⊕ arr[i - 1]，即，prefix[i] 代表前 i 个数的异或值
     * 可得出等式 ⑤：prefix[i] = prefix[k + 1] ———— ⑤
     * ===================================================================================
     * 即：需要找到 i j k 且：
     * - 0 <= i < j <= k < arr.length
     * - prefix[i] = arr[0] ⊕...⊕ arr[i - 1]
     * 使得：
     * - prefix[i] = prefix[k + 1]
     * ====================================================================================
     * 令 prefix[i] = arr[0] ⊕...⊕ arr[i - 1] 后，简化上述推断：
     * ①: arr[i] ⊕ ... ⊕ arr[j-1] = arr[j] ⊕...⊕ arr[k]
     * ②: (prefix[i] ⊕ prefix[i]) ⊕ arr[i] ⊕ ... ⊕ arr[j-1] = (prefix[j] ⊕ prefix[j]) ⊕ arr[j] ⊕ ... ⊕ arr[k]
     * ③: (prefix[i] ⊕ prefix[j]) =  (prefix[j] ⊕ prefix[k + 1])
     * ④: prefix[i] = prefix[k + 1]
     */
    public int countTriplets(int[] arr) {
        int len = arr.length;
        // 定义 prefix 数组代表前 i 个数的异或值：
        // prefix[0] = 0;
        // prefix[i] = arr[0] ⊕...⊕ arr[i - 1]  ———— i > 0
        int[] prefix = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = j; k < len; ++k) {
                    if (prefix[i] == prefix[k + 1]) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
}