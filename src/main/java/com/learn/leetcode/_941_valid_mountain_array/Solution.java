package com.learn.leetcode._941_valid_mountain_array;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/11/3 19:29
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < len && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == len - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < len && A[i] > A[i + 1]) {
            i++;
        }

        return i == len - 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(new int[]{1, 3, 2}));
    }

}
