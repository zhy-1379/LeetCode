package com.learn.leetcode._421_maximum_xor_of_two_numbers_in_an_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中两个数的最大异或值
 * 参考答案：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-h-n9m9/
 *
 * @author zhy
 */
public class Solution {

    public int findMaximumXOR(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int highPosition;
        for (highPosition = 0; ; highPosition++) {
            if (max >> highPosition == 0) {
                break;
            }
        }

        // 从高位到低位依次计算 maxXOR 的值
        int maxXOR = 0;
        // nums 中，最大值的最高位为 highPosition；则：假设异或值的最大值的最高位也为 highPosition
        for (int k = highPosition - 1; k >= 0; --k) {
            // nums 前 k 位的值
            Set<Integer> preK = new HashSet<>();
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                preK.add(num >> k);
            }

            // 能否找到让前 k 位异或后，最大值位 maxNext 的值，即下一位为 1；否则下一位为 0
            boolean foundMax = false;
            // 假设 maxXOR 的第 k 个二进制位置为 1，得到可能的最大值： maxXOR = (maxXOR << 1) + 1
            int maxNext = (maxXOR << 1) + 1;

            // 枚举 i
            for (int num : nums) {
                if (preK.contains(maxNext ^ (num >> k))) {
                    foundMax = true;
                    break;
                }
            }

            if (foundMax) {
                maxXOR = maxNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 maxXOR 的第 k 个二进制位只能为 0
                // 即为 maxXOR = maxXOR << 2
                maxXOR = maxNext - 1;
            }
        }
        return maxXOR;
    }

}